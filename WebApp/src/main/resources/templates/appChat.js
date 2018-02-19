var stompClient = null;

function setConnected(connected) {
    $('#connect').prop("disabled", connected);
    $('#disconnect').prop("disabled", !connected);
    if(connected) {
        $('#conversation').show();
    } else {
        $('#conversation').hide();
    }
    $('#onlineX').html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected → ' + frame);
        stompClient.subscribe('/chat/online', function (msg) {
            showMessage(JSON.parse(msg.body).message);
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log('Disconnected');
}

function sendMessage() {
    stompClient.send("/appChat/msg", {}, JSON.stringify({'message' : $('#message').val() }));
}

function showMessage(message) {
    $('#onlineX').append("<tr><td>" + message + "</td></tr>");
}

$(function (){
   $('form').on('submit', function (e) {
        e.preventDefault();
   });
   $('#connect').click(function() {
    connect();
   });
   $('#disconnect').click(function() {
       disconnect();
      });
    $('#send').click(function() {
        sendMessage();
       });
});