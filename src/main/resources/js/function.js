function postAction(url){
    var jqxhr = $.post( url, function() {
      alert( "success" );
    })
      .done(function() {
        alert( "second success" );
      })
      .fail(function() {
        alert( "error" );
      })
      .always(function() {
        alert( "finished" );
      });

      jqxhr.always(function(){
        alert("Another finished");
      })

}

function getAction(){
}
