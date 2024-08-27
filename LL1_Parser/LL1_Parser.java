package LL1_Parser;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Ajdar
 */
public class LL1_Parser {
    
    private HashMap<String, Set<String>> normalizedGE = null;
    private HashMap<String, Set<String>> first = null;
    private HashMap<String, Set<String>> follow = null;
    private Set<String> nonTerminals = null;
    private Set<String> terminals = null;
    private HashMap<String, HashMap<String, String>> Parse_Table = null;
    private String initialState = "";
    private ArrayList<Object[]> logs = null;
    
    public LL1_Parser(PrepareGrammar cfg){
        this.normalizedGE = cfg.getNormalizedGE();
        this.first = cfg.getFirst();
        this.follow = cfg.getFollow();
        this.nonTerminals = cfg.getNonTerminals();
        this.terminals = cfg.getTerminals();
        this.Parse_Table = cfg.getmTableFirstRule();
        this.initialState = cfg.getInitialState();
    }
    
    public void compute_LL1_Table(){
        for(String nonTerminal : nonTerminals){ //M Table Second Rule
            Set<String> firstNT = first.get(nonTerminal);
            if(firstNT.contains("&")){
                Set<String> followNT = follow.get(nonTerminal);
                for(String terminal : followNT){
                    Parse_Table.get(nonTerminal).put(terminal, "&");
                }
                if(followNT.contains("$")){
                    Parse_Table.get(nonTerminal).put("$", "&");
                }
            }
        }
    }
    
    public boolean acceptedWord(String word){
        word = word.replaceAll("&", "");
        logs = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push("$");
        stack.push(initialState);
        word+="$";
        String ae = word.charAt(0) + "", X = "";
        int idx = 0;
        logs.add(new Object[]{"$"+initialState, word, ""});
        do{
            X = stack.peek();
            if(X.equals("&")){
                stack.pop();
                continue;
            }
            if(isTerminal(X) || X.equals("$")){
                if(X.equals(ae)){
                    stack.pop();
                    idx++;
                    if(idx < word.length() && !stack.empty()){
                        logs.add(new Object[]{stack.toString(), word.substring(idx), ""});
                    }
                } else {
                    System.out.println("Error 1!");
                    break;
                }
            } else {
                if(produce(X, ae)){
                    stack.pop();
                    String production = Parse_Table.get(X).get(ae);
                    String swappedProd = swapProduction(production);
                    swappedProd = swappedProd.replaceAll("&", "");
                    pushOnStack(stack, swappedProd);
                    if(idx < word.length() && !stack.empty()){
                        logs.add(new Object[]{stack.toString(), word.substring(idx), X + "->" +production});
                    }
                } else {
                    System.out.println("Error 2!");
                    break;
                }
            }
            if(idx < word.length()) ae = word.charAt(idx) + "";
            else break;
        } while(!X.equals("$"));
        return X.equals("$") && ae.equals("$");
    }
    
    private boolean isTerminal(String symbol){
        return terminals.contains(symbol);
    }
    
    private boolean produce(String nonTerminal, String terminal){
        return Parse_Table.get(nonTerminal).get(terminal) != null;
    }
    
    private String swapProduction(String production){
        String swappedProd = "";
        for(int i = production.length() - 1; i >= 0; i--){
            swappedProd+=production.charAt(i);
        }
        return swappedProd;
    }
    
    private void pushOnStack(Stack<String> stack, String swappedProd){
        for(int i = 0; i < swappedProd.length(); i++){
            String comma = "";
            while(i < swappedProd.length() && "'".equals(swappedProd.charAt(i) + "")){
                comma+="'";
                i++;
            }
            String symbol = swappedProd.charAt(i) + comma;
            stack.add(symbol);
        }
    }

    public HashMap<String, HashMap<String, String>> getmTable() {
        return Parse_Table;
    }

    public ArrayList<Object[]> getLogs() {
        return logs;
    }
}
