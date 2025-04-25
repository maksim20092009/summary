// Функция переключения разделов
function showSection(sectionId) {
    document.querySelectorAll('.content').forEach(section => section.classList.remove('active'));
    document.getElementById(sectionId).classList.add('active');
}

// Фильтрация отелей по городу, цене, звёздам и удобствам
function filterHotels() {
    let selectedCity = document.getElementById("city").value;
    let maxPrice = document.getElementById("price").value;
    let selectedStars = document.getElementById("stars").value;
    let selectedAmenities = document.getElementById("amenities").value;

    document.querySelectorAll(".hotel").forEach(hotel => {
        let hotelCity = hotel.getAttribute("data-city");
        let hotelPrice = parseInt(hotel.getAttribute("data-price"));
        let hotelStars = hotel.getAttribute("data-stars");
        let hotelAmenities = hotel.getAttribute("data-amenities").split(",");

        let cityMatch = selectedCity === "all" || hotelCity === selectedCity;
        let priceMatch = !maxPrice || hotelPrice <= maxPrice;
        let starsMatch = selectedStars === "all" || hotelStars === selectedStars;
        let amenitiesMatch = selectedAmenities === "all" || hotelAmenities.includes(selectedAmenities);

        if (cityMatch && priceMatch && starsMatch && amenitiesMatch) {
            hotel.style.display = "block";
        } else {
            hotel.style.display = "none";
        }
    });
}

// Расчет стоимости бронирования
function updatePrice() {
    let hotelPrice = parseInt(document.getElementById("hotel").selectedOptions[0].dataset.price);
    let roomPrice = parseInt(document.getElementById("room").selectedOptions[0].dataset.price);
    let total = hotelPrice + roomPrice;
    document.getElementById("total-price").textContent = total;
}

// Обновление цены при изменении отеля или типа номера
document.getElementById("hotel").addEventListener("change", updatePrice);
document.getElementById("room").addEventListener("change", updatePrice);
updatePrice(); // Вызываем функцию сразу для отображения начальной стоимости

// Обработка бронирования
document.getElementById("booking-form").addEventListener("submit", function(event) {
    event.preventDefault();

    let hotel = document.getElementById("hotel").value;
    let room = document.getElementById("room").value;
    let checkin = document.getElementById("checkin").value;
    let checkout = document.getElementById("checkout").value;
    let guests = document.getElementById("guests").value;
    let totalPrice = document.getElementById("total-price").textContent;

    if (hotel && room && checkin && checkout && guests) {
        alert(`✅ Бронирование подтверждено!\nОтель: ${hotel}\nТип номера: ${room}\nДаты: ${checkin} - ${checkout}\nГостей: ${guests}\nСтоимость: $${totalPrice}`);
    } else {
        alert("⚠️ Заполните все поля!");
    }
});

// Обработка отзывов
document.getElementById("review-form").addEventListener("submit", function(event) {
    event.preventDefault();

    let reviewText = document.getElementById("user-review").value;
    if (reviewText) {
        let reviewList = document.getElementById("review-list");
        let newReview = document.createElement("p");
        newReview.textContent = reviewText;
        reviewList.appendChild(newReview);
        document.getElementById("user-review").value = "";
        alert("Спасибо за ваш отзыв! 💬");
    } else {
        alert("⚠️ Введите отзыв!");
    }
});

// Применение скидок при бронировании
function applyOffers() {
    let nights = document.getElementById("nights").value;
    let totalPrice = parseInt(document.getElementById("total-price").textContent);

    document.querySelectorAll("#offers-list li").forEach(offer => {
        if (offer.dataset.discount) {
            totalPrice *= (1 - parseInt(offer.dataset.discount) / 100); // Применение %-ной скидки
        }
        if (offer.dataset.nights && nights >= parseInt(offer.dataset.nights)) {
            totalPrice -= 100; // Скидка на длительное проживание
        }
        if (offer.dataset.breakfast && nights >= parseInt(offer.dataset.breakfast)) {
            document.getElementById("breakfast-info").textContent = "✅ Бесплатный завтрак включен!";
        }
    });

    document.getElementById("total-price").textContent = totalPrice.toFixed(2);
}

// Функция загрузки отзывов из localStorage
function loadReviews() {
    let reviews = JSON.parse(localStorage.getItem("reviews")) || [];
    let reviewsContainer = document.getElementById("reviews-container");

    reviewsContainer.innerHTML = ""; // Очищаем список перед загрузкой новых отзывов

    reviews.forEach(review => {
        let li = document.createElement("li");
        li.innerHTML = `<strong>${review.name}</strong> (${review.hotel}): ${review.text}`;
        reviewsContainer.appendChild(li);
    });
}

// Функция добавления нового отзыва
document.getElementById("review-form").addEventListener("submit", function(event) {
    event.preventDefault();

    let name = document.getElementById("user-name").value;
    let hotel = document.getElementById("hotel-review").value;
    let reviewText = document.getElementById("user-review").value;

    if (name && hotel && reviewText) {
        let reviews = JSON.parse(localStorage.getItem("reviews")) || [];
        reviews.push({ name, hotel, text: reviewText });
        localStorage.setItem("reviews", JSON.stringify(reviews));

        loadReviews(); // Обновляем список отзывов
        document.getElementById("review-form").reset();
        alert("Спасибо за ваш отзыв! 💬");
    } else {
        alert("⚠️ Пожалуйста, заполните все поля!");
    }
});

// Загружаем отзывы при загрузке страницы
loadReviews();

function toggleFAQ(element) {
    let answer = element.nextElementSibling;
    answer.style.display = answer.style.display === "block" ? "none" : "block";
}

document.addEventListener("DOMContentLoaded", function () {
    let faqItems = document.querySelectorAll(".faq-item h3");

    faqItems.forEach(item => {
        item.addEventListener("click", function () {
            let answer = this.nextElementSibling;
            let parent = this.parentElement;

            let isOpen = parent.classList.contains("active");

            // Закрываем все ответы перед открытием нового
            document.querySelectorAll(".faq-item").forEach(faq => {
                faq.classList.remove("active");
                faq.querySelector(".faq-answer").style.maxHeight = "0";
                faq.querySelector(".faq-answer").style.opacity = "0";
            });

            // Если он уже открыт, просто закрываем его
            if (isOpen) {
                parent.classList.remove("active");
                answer.style.maxHeight = "0";
                answer.style.opacity = "0";
            } else {
                parent.classList.add("active");
                answer.style.maxHeight = answer.scrollHeight + "px";
                answer.style.opacity = "1";
            }
        });
    });
});

document.getElementById("contact-form").addEventListener("submit", function(event) {
    event.preventDefault();

    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let message = document.getElementById("message").value;

    if (name && email && message) {
        alert(`✅ Спасибо, ${name}! Ваше сообщение отправлено.`);
        document.getElementById("contact-form").reset();
    } else {
        alert("⚠️ Заполните все поля!");
    }
});

function updateEventPrice() {
    let eventPrice = parseInt(document.getElementById("event-type").selectedOptions[0].dataset.price);
    let guests = document.getElementById("guests").value;
    let totalPrice = eventPrice + (guests * 20); // Доплата $20 за каждого гостя

    document.getElementById("event-price").textContent = totalPrice.toFixed(2);
}

// Обновление цены при изменении типа мероприятия или количества гостей
document.getElementById("event-type").addEventListener("change", updateEventPrice);
document.getElementById("guests").addEventListener("change", updateEventPrice);
updateEventPrice();

// Обработка бронирования мероприятия
document.getElementById("event-form").addEventListener("submit", function(event) {
    event.preventDefault();

    let eventType = document.getElementById("event-type").value;
    let eventDate = document.getElementById("event-date").value;
    let guests = document.getElementById("guests").value;
    let totalPrice = document.getElementById("event-price").textContent;

    if (eventType && eventDate && guests) {
        alert(`✅ Мероприятие забронировано!\nТип: ${eventType}\nДата: ${eventDate}\nГостей: ${guests}\nСтоимость: $${totalPrice}`);
    } else {
        alert("⚠️ Заполните все поля!");
    }
});

function openWindow(id) {
    let windowElement = document.getElementById(id);
    if (windowElement) {
        windowElement.style.display = "block";
        windowElement.classList.add("active");
    }
}

function closeWindow(id) {
    let windowElement = document.getElementById(id);
    if (windowElement) {
        windowElement.classList.remove("active");
        setTimeout(() => {
            windowElement.style.display = "none";
        }, 300);
    }
}

document.getElementById("hotel").addEventListener("change", updateTotal);
document.getElementById("room").addEventListener("change", updateTotal);
document.getElementById("guests").addEventListener("input", updateTotal);

function updateTotal() {
    let hotel = document.getElementById("hotel");
    let room = document.getElementById("room");
    let guests = document.getElementById("guests").value || 1;

    let hotelPrice = hotel.options[hotel.selectedIndex].dataset.price || 0;
    let roomPrice = room.options[room.selectedIndex].dataset.price || 0;

    let totalPrice = (parseInt(hotelPrice) + parseInt(roomPrice)) * guests;

    let priceElement = document.getElementById("total-price");
    priceElement.textContent = totalPrice;
    priceElement.style.transform = "scale(1.2)";
    setTimeout(() => priceElement.style.transform = "scale(1)", 300);
}