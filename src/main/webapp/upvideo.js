function addChapter(form, chapterValue) {
    document.getElementById('fillChapterId').value = chapterValue;
    document.getElementById(form).submit();
}
function goTo(url) {
    window.location = url;
}
function toggleDropdown() {
    var dropdown = document.getElementById("dropdownList");
    if (dropdown.style.display === "block") {
        dropdown.style.display = "none";
        document.getElementById("myNav").style.width = "0%";
    } else {
        dropdown.style.display = "block";
        document.getElementById("myNav").style.width = "100%";
    }
}

function closeNav() {
    document.getElementById("myNav").style.width = "0%";
    var dropdown = document.getElementById("dropdownList");

    dropdown.style.display = "none";
}
function toWhite(element) {
    var anchor = element.querySelector('a');
    if (anchor) {
        anchor.style.color = 'white';
    }
}

function toBlack() {
    var firstChild = document.querySelectorAll('.list-item > a');
    firstChild.forEach(element => {
        element.style.color = 'black';
    });
}
function showLessons(chapter) {
    var parent = chapter.parentNode;
    var lessons = parent.querySelector(".lessons").querySelectorAll(".lesson");

    lessons.forEach(function (lesson) {
        lesson.style.display = lesson.style.display === "block" ? "none" : "block";
    });
}

import { initializeApp } from "https://www.gstatic.com/firebasejs/10.8.1/firebase-app.js";

const firebaseConfig = {
    apiKey: "AIzaSyAJKsKUAIJgADybf-k1S21XzVupQc8ZAkw",
    authDomain: "videoproject-f3e9d.firebaseapp.com",
    projectId: "videoproject-f3e9d",
    storageBucket: "videoproject-f3e9d.appspot.com",
    messagingSenderId: "367162859984",
    appId: "1:367162859984:web:95dd72fd3dab16f5f719d5",
    measurementId: "G-XYV7FHE76R"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
var fileText = document.querySelector('.fileText');
var uploadPercentage = document.querySelector('.uploadPercentage');
var progress = document.querySelector('.progress');
var percentVal;
var fileItem;
var fileName;
function getFile(e) {
    fileItem = e.target.files[0];
    fileName = fileItem.name;
    fileText.innerHTML = fileName;
}

function uploadImg() {
    let storageRef = app.storage().ref('videos/' + fileName);
    let uploadTask = storageRef.put(fileItem);
    uploadTask.on('state_changed', function (snapshot) {
        percentVal = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
        progress.style.width = percentVal + '%';
        uploadPercentage.innerHTML = Math.round(percentVal) + '%';
    }, function (error) {
        console.log(error);
    }, function () {
        uploadTask.snapshot.ref.getDownloadURL().then(function (downloadURL) {
            console.log('File available at', downloadURL);
        });
    });
}

