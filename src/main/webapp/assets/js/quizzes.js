/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function addNewAnswer(button) {

    var parent = button.parentNode;
    var numOfAns = parseInt(parent.querySelector('.numOfAns').value);
    var indexAns = parseInt(parent.querySelector('.indexAns').value);
    var numOfQues = parseInt(parent.querySelector('.numOfQuesInside').value);
    if (numOfAns === 6) {
    } else {
        numOfAns++;
        indexAns++;
        parent.querySelector('.numOfAns').value = numOfAns;
        parent.querySelector('.indexAns').value = indexAns;
        parent.querySelector(`.answers${numOfQues}`).insertAdjacentHTML('beforeend', `<div style="display: flex" id="answerBox${numOfQues}${indexAns}">
    <td>
        <input type="checkbox" name="question${numOfQues}-${indexAns}" id="answer-${numOfQues}-${indexAns}" value="true">
        <label for="answer-${numOfQues}-${indexAns}" class="custom-checkbox"></label>
    </td>  
    <td style="width: 50%;"><div class="answer-box">
            <textarea style="width: 95%; margin:0 1.2% 0 1%; border: none;" name="q${numOfQues}-answer${indexAns}">A1: </textarea>
            <button type="button" onclick="deleteAnswer('answerBox${numOfQues}${indexAns}')" style=" border: none; background: none;" type="submit" class="delete-answer" value="delete"><svg style="margin-bottom: 75%; color: rgba(0,0,0,0.5);" xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                </svg>
            </button>
        </div>
    </td>
</div>`);
    }
}

function displayQuestions(questions) {
    const questionsList = document.getElementById('questions');
    var indexQ = parseInt(document.getElementById('index').value);
    var quest = parseInt(document.querySelector(`#quest`).value);
    questions.forEach(function (questionObj) {
        quest++;
        indexQ++;
        document.getElementById('index').value = indexQ;
        questionsList.innerHTML += `<div class="question-container question${indexQ}" style="margin-top:30px;">
                            <input type="hidden" value="${indexQ}" class="numOfQuesInside">
                            <input type="hidden" value="${questionObj.answers.length}" class="numOfAns">
                            <input type="hidden" value="${questionObj.answers.length}" class="indexAns" name="indexAns${indexQ}">
                            <div class="question-text" style="position: relative; display: flex">
                                Question 1:
                                <textarea style="width: 88%; margin:0 1.2% 1.5% 1%; border: none;" name="q${indexQ}">${questionObj.question}</textarea>
                                <button  style="position: absolute; right: 12px; top: 18px;" type="button" onclick="deleteQuestion(this)" class="delete-button" value="delete"><svg xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                    <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                    </svg>
                                </button>
                            </div>
                            <div class="answers${indexQ}"></div>
                            
                            <button class="add-new-answer" type="button" onclick="addNewAnswer(this)">Add new answer</button>
                        </div>`;

        var answerList = document.querySelector(`.answers${indexQ}`);
        var currentAnswerIndex = 0;
        questionObj.answers.forEach(function (answer) {
            answerList.innerHTML += `<div style="display: flex" id="answerBox${indexQ}${currentAnswerIndex + 1}">
                                    <td><input type="checkbox" name="question${indexQ}-${currentAnswerIndex + 1}" id="answer-${indexQ}-${currentAnswerIndex + 1}" ${questionObj.isTrue[currentAnswerIndex] ? "checked" : ""} value="true">
                                        <label for="answer-${indexQ}-${currentAnswerIndex + 1}" class="custom-checkbox"></label></td>
                                    <td style="width: 50%;"><div class="answer-box">
                                            <textarea style="width: 95%; margin:0 1.2% 0 1%; border: none;" name="q${indexQ}-answer${currentAnswerIndex + 1}">${answer}</textarea>
                                            <button type="button" onclick="deleteAnswer('answerBox${indexQ}${currentAnswerIndex + 1}')" style=" border: none; background: none;" type="submit" class="delete-answer" value="delete"><svg style="margin-bottom: 75%; color: rgba(0,0,0,0.5);" xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                                <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                                </svg>
                                            </button>
                                        </div>
                                    </td>
                                </div>`;
            currentAnswerIndex++;
        });

    });
    document.querySelector(`#quest`).value = quest;
}

function addQuestion(button) {
    var index = parseInt(document.getElementById('index').value) + 1;
    document.getElementById('index').value = index;
    var numQuest = parseInt(document.getElementById('quest').value) + 1;
    document.getElementById('quest').value = numQuest;
    var grandParent = button.parentNode.parentNode;
    var questions = grandParent.querySelector('#questions');
    questions.insertAdjacentHTML('beforeend', `<div class="question-container question${index}" style="margin-top:30px;">
                        <input type="hidden" value="${index}" class="numOfQuesInside">
                        <input type="hidden"  value="4" class="numOfAns">
                        <input type="hidden" value="4" class="indexAns" name="indexAns${index}">
    
                        <div class="question-text" style="position: relative; display: flex">
                            <textarea style="width: 89%; margin:1% 1.2% 1.5% 5.5%; border: none;" name="q${index}"></textarea>
                            <button style="position: absolute; right: 12px; top: 18px;" type="button" class="delete-button" onclick="deleteQuestion(this)" value="delete"><svg xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                </svg>
                            </button>

                        </div>
                        <div class="answers${index}">
                            <div style="display: flex" id="answerBox${index}1">
                                <td><input type="checkbox" name="question${index}-1" id="answer-${index}-1" value="true">
                                    <label for="answer-${index}-1" class="custom-checkbox"></label></td>
                                <td style="width: 50%;"><div class="answer-box">
                                        <textarea style="width: 95%; margin:0 1.2% 0 1%; border: none;" name="q${index}-answer1">A1:</textarea>
                                        <button type="button" onclick="deleteAnswer('answerBox${index}1')" style=" border: none; background: none;" type="submit" class="delete-answer" value="delete"><svg style="margin-bottom: 75%; color: rgba(0,0,0,0.5);" xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                            <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                            </svg>
                                        </button>
                                    </div>
                                </td>
                            </div>
                            <div style="display: flex" id="answerBox${index}2">
                                <td><input type="checkbox" name="question${index}-2" id="answer-${index}-2" value="true">
                                    <label for="answer-${index}-2" class="custom-checkbox"></label></td>
                                <td style="width: 50%;"><div class="answer-box">
                                        <textarea style="width: 95%; margin:0 1.2% 0 1%; border: none;" name="q${index}-answer2">A2:</textarea>
                                        <button type="button" onclick="deleteAnswer('answerBox${index}2')" style=" border: none; background: none;" type="submit" class="delete-answer" value="delete"><svg style="margin-bottom: 75%; color: rgba(0,0,0,0.5);" xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                            <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                            </svg>
                                        </button>
                                    </div>
                                </td>
                            </div>
                            <div style="display: flex" id="answerBox${index}3">
                                <td><input type="checkbox" name="question${index}-3" id="answer-${index}-3" value="true">
                                    <label for="answer-${index}-3" class="custom-checkbox"></label></td>
                                <td style="width: 50%;"><div class="answer-box">
                                        <textarea style="width: 95%; margin:0 1.2% 0 1%; border: none;" name="q${index}-answer3">A3:</textarea>
                                        <button type="button" onclick="deleteAnswer('answerBox${index}3')"style=" border: none; background: none;" type="submit" class="delete-answer" value="delete"><svg style="margin-bottom: 75%; color: rgba(0,0,0,0.5);" xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                            <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                            </svg>
                                        </button>
                                    </div>
                                </td>
                            </div>
                            <div style="display: flex" id="answerBox${index}4">
                                <td><input type="checkbox" name="question${index}-4" id="answer-${index}-4" value="true">
                                    <label for="answer-${index}-4" class="custom-checkbox"></label></td>
                                <td style="width: 50%;"><div class="answer-box">
                                        <textarea style="width: 95%; margin:0 1.2% 0 1%; border: none;" name="q${index}-answer4">A4:</textarea>
                                        <button type="button" onclick="deleteAnswer('answerBox${index}4')" style=" border: none; background: none;" type="submit" class="delete-answer" value="delete"><svg style="margin-bottom: 75%; color: rgba(0,0,0,0.5);" xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                            <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                            </svg>
                                        </button>
                                    </div>
                                </td>
                            </div>
                        </div>

                        <!-- Button to add new answer -->
                        <button class="add-new-answer" type="button" onclick="addNewAnswer(this)">Add new answer</button>
                    </div>`);
}