// Khlaid Helayhel 442017074
var Gender = document.querySelector('#Male')
var Age = document.querySelector('#Age')
var Height = document.querySelector('#Height')
var Button = document.querySelector('#submit')
var ResultCont = document.querySelector('.result-cont')



function BMI(Gender,Height){
    var result = 0
    if(Gender.checked){
       result =  Age + 1.1 * (Height - 150) 
    }else{
        result =  Age + 0.9 * (Height - 150)
    }
    return result
}

Button.addEventListener('click', (e)=> {
    e.preventDefault()

    var userHeight = parseInt(Height.value)
    ResultCont.innerHTML = `
    <h3 style = "color : green;">Calculating ${Gender.checked ? 'male' : 'female'} perfect weight...</h3>
    <h4 style="text-decoration: underline;">The given height is:</h3>
    <li> Your height: ${userHeight}cm</li>
    <h4>The perfect weight is: ${BMI(Gender,userHeight).toFixed(2)}kg</h4>`

})