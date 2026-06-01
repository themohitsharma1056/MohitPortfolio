
const hamburger = document.getElementById("hamburger");

const mobileMenu = document.getElementById("mobileMenu");

const closeBtn = document.getElementById("closeBtn");

hamburger.addEventListener("click", () => {

    mobileMenu.classList.add("active");

});

closeBtn.addEventListener("click", () => {

    mobileMenu.classList.remove("active");

});





const reveals = document.querySelectorAll(".reveal");

window.addEventListener("scroll", () => {

    reveals.forEach((element) => {

        const windowHeight = window.innerHeight;

        const revealTop = element.getBoundingClientRect().top;

        const revealPoint = 100;

        if(revealTop < windowHeight - revealPoint){

            element.classList.add("active");

        }

    });

});

window.dispatchEvent(new Event("scroll"));


