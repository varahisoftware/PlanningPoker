var socket = new SockJS('/ws');
var stompClient = Stomp.over(socket);
stompClient.connect({}, function (frame) {
    console.log('Connected: ' + frame);
    stompClient.subscribe('/websocket/GlobalMSG', function (frame) {
        const msg = frame.body;
        console.log("New Message: " + msg);
        displayGlobalMSG(msg);
    });
});

function displayGlobalMSG(msg){
    $("#websocketMsgId").text(msg).show().delay(5000).fadeOut();
}