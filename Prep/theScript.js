var Calculate = document.querySelector('button');
var output = document.querySelector('h4');

Calculate.addEventListener('click', (event) => {
  event.preventDefault();
  let selected = document.querySelector('input[id="Male"]:checked');
  let selected1 = document.querySelector('input[id="Female"]:checked');

  if (selected!== null) {
    output.innerText = "Your Sleeping Daily is:  6 to 8 Hours";
  }

  if (selected1!== null) {
    output.innerText = "Your Sleeping Daily is: 5 to 9 Hours";
  }
});


