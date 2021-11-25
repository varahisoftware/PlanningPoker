function displayGlobalMSG(msg){
    $("#websocketMsgId").text(msg).show().delay(5000).fadeOut();
}

function connectToPlanningPokerWS(sessionId){
    var socket = new SockJS('/ws');
    var stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        // console.log('Connected: ' + frame);
        stompClient.subscribe(sessionCommunicationTopicPrefix+sessionId, function (frame) {
            const msg = frame.body;
            console.log("Received Message: " + msg);
        });
    });
}
