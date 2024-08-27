let ShowQuote = document.getElementById('ShowQuote');
let ShowTime = document.getElementById('ShowTime');
let result = document.getElementById('result');
let arr =["file:///C:/Users/Lenovo/Desktop/Html/Experimental/quoteIcon.png", "file:///C:/Users/Lenovo/Desktop/Html/Experimental/dateIcon.png"]



let quotes = [ "Life is like a landscape. You live in the midst of it but can describe it only from the vantage point of distance",
   "The price of anything is the amount of life you exchange for it",
   "Be yourself; everyone else is already taken", "You only live once, but if you do it right, once is enough",
   "If you tell the truth, you don't have to remember anything",
   "Live as if you were to die tomorrow. Learn as if you were to live forever",
   "If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success",
   "always remember that you are absolutely unique. Just like everyone else",
   "The future belongs to those who believe in the beauty of their dreams"];
  ShowQuote.addEventListener("click", function(event){
   event.preventDefault();
   document.getElementById("image").src = arr[0];
   var randomQuote =  quotes[Math.floor(Math.random() * quotes.length) ]
    result.innerHTML = '"'+randomQuote+'"';

  })
  ShowTime.addEventListener("click", function(event){
   event.preventDefault();
   document.getElementById("image").src = arr[1];
   var date = new Date();
   result.innerHTML = date;
  })