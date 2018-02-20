var stompClient = null;

function setConnected(connected) {
    $('#connect').prop("disabled", connected);
    $('#disconnect').prop("disabled", !connected);
    if(connected) {
        $('#conversation').show();
    } else {
//        $('#conversation').hide();
        $('#conversation').show();
    }
    $('#onlineX').html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    userName = $('#userName').val();
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected → ' + frame);
        stompClient.subscribe('/chat/online', function (msg) {
//            var msgX = $('#userName').val() + '>' + JSON.parse(msg.body).message;
//            var msgX = userName + ' >> ' + JSON.parse(msg.body).message;
//            var msgX = ' >> ' + JSON.parse(msg.body).message;
            var msgX = JSON.parse(msg.body).message;
            showMessage(msgX);
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
    stompClient.send("/appChat/msg", {}, JSON.stringify({'name' : $("#message").val() }));
    var x = document.getElementsByName('msg-form')[0];
    x.reset();
}

function showMessage(messageX) {
    $("#onlineX").append("<tr><td>" + messageX + "</td></tr>");
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
