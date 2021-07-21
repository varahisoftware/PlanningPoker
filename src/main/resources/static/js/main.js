$("#actionMsgId").show().delay(5000).fadeOut();
$("#warnMsgId").show().delay(5000).fadeOut();
$("#errorMsgId").show().delay(5000).fadeOut();

function invokeActionMsg(message){
  $("#actionMsgId").val(message).show().delay(5000).fadeOut();
}