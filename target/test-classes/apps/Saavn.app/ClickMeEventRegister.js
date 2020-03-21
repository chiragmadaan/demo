var button = document.getElementById("btn_submit");
button.addEventListener("click", function() {
            var messageToPost = {'buttonID':'btn_submit'};
            window.webkit.messageHandlers.buttonClicked.postMessage(messageToPost);
        },false);
