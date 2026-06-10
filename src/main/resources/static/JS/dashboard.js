console.log("Proxiva Dashboard Loaded");

// Service and stat hover effect
const cards = document.querySelectorAll(".service, .stat");

cards.forEach(card => {
    card.addEventListener("mouseenter", () => {
        card.style.transform = "translateY(-8px) scale(1.02)";
        card.style.transition = "0.3s ease";
    });

    card.addEventListener("mouseleave", () => {
        card.style.transform = "translateY(0px) scale(1)";
    });
});

// Search bar glow effect
const searchInput = document.querySelector(".topbar input");

if (searchInput) {
    searchInput.addEventListener("focus", () => {
        searchInput.style.boxShadow = "0 0 25px rgba(124,58,237,0.35)";
    });

    searchInput.addEventListener("blur", () => {
        searchInput.style.boxShadow = "0 10px 25px rgba(0,0,0,0.08)";
    });
}

// Hero icon floating effect
const heroIcons = document.querySelector(".hero-icons");

if (heroIcons) {
    let move = false;

    setInterval(() => {
        heroIcons.style.transform = move ? "translateY(0px)" : "translateY(-10px)";
        heroIcons.style.transition = "1.5s ease";
        move = !move;
    }, 1500);
}

// Button click small effect
const buttons = document.querySelectorAll("button");

buttons.forEach(button => {
    button.addEventListener("click", () => {
        button.style.transform = "scale(0.95)";

        setTimeout(() => {
            button.style.transform = "scale(1)";
        }, 150);
    });
});