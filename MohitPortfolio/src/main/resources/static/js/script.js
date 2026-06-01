
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
const progressBar =
document.getElementById("scroll-progress");



window.addEventListener("scroll", () => {

	const winScroll =
	window.scrollY;

	    const height =
	    document.body.scrollHeight -
	    window.innerHeight;

	    const progress =
	    (winScroll / height) * 100;

	    progressBar.style.width =
	    progress + "%";

	});
	window.addEventListener("load", () => {

	    const loader =
	    document.getElementById("loader");

	    setTimeout(() => {

	        loader.style.opacity = "0";

	        loader.style.visibility = "hidden";

	    }, 300);

	});
	document.querySelectorAll("a").forEach(link => {

	    link.addEventListener("click", function(e) {

	        const href = this.getAttribute("href");

	        if(
	            href &&
	            !href.startsWith("#") &&
	            !href.startsWith("http")
	        ){

	            e.preventDefault();

	            document.body.classList.add("fade-out");

	            setTimeout(() => {

	                window.location.href = href;

	            }, 350);
	        }
	    });

	});
	
	const currentPage =
	window.location.pathname;
	if(currentPage === "/"){

	    document
	    .getElementById("homeLink")
	    .classList
	    .add("active");

	    document
	    .getElementById("mobileHomeLink")
	    .classList
	    .add("active");

	}
	if(currentPage === "/about"){

	    document.getElementById("aboutLink")
	    .classList.add("active");

	    document.getElementById("mobileAboutLink")
	    .classList.add("active");

	}
	if(currentPage === "/projects"){

	    document.getElementById("projectsLink")
	    .classList.add("active");

	    document.getElementById("mobileProjectsLink")
	    .classList.add("active");

	}
	
	if(currentPage === "/skills"){

	    document.getElementById("skillsLink")
	    .classList.add("active");

	    document.getElementById("mobileSkillsLink")
	    .classList.add("active");

	}
	if(currentPage === "/contact"){

	    document.getElementById("contactLink")
	    .classList.add("active");

	    document.getElementById("mobileContactLink")
	    .classList.add("active");

	}