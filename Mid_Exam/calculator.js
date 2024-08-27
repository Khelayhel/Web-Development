document.getElementById("result").style.display = 'none';

const btn = document.getElementById("btn");
const birthday = document.getElementById("birthday");
const nameInput = document.getElementById("name");
const result = document.getElementById("result");

function calculateAge() {
    document.getElementById("result").style.display = 'flex';
    const name = nameInput.value.trim();
    const birthdayValue = birthday.value;

    if (birthdayValue === "") {
        alert("Please enter your birthday");
        return;
    } else if (name === "") {
        alert("Please enter your name");
        return;
    }

    const age = getAge(birthdayValue);
    result.innerHTML = `
        <strong>Name: ${name}</strong><br>
        <strong>Age: ${age} ${age > 1 ? "years" : "year"} old</strong>
    `;
}

function getAge(birthdayValue) {
    const currentDate = new Date();
    const birthdayDate = new Date(birthdayValue);
    let age = currentDate.getFullYear() - birthdayDate.getFullYear();
    const month = currentDate.getMonth() - birthdayDate.getMonth();

    if (
        month < 0 ||
        (month === 0 && currentDate.getDate() < birthdayDate.getDate())
    ) {
        age--;
    }

    return age;
}

btn.addEventListener("click", calculateAge);
