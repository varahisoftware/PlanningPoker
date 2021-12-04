function displayGlobalMSG(msg){
    $("#websocketMsgId").text(msg).show().delay(5000).fadeOut();
}

function isJson(obj){
    try{
        JSON.parse(obj);
        return true;
    }catch(e){
        return false;
    }
}