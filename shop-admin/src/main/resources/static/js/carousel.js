$( "form" ).submit(function( event ) {
    console.log($( this ).serializeArray());

    var formData = $( this ).serializeArray();
    var data = {};
    for(var i = 0; i < formData.length; i++) {
        var key = formData[i].name;
        var value = formData[i].value;
        data[key] = value;
    }
    console.log(data);

    $.ajax({
        type: "POST",
        url: "/carousel",
        data: JSON.stringify(data),
        contentType: 'application/json;charset=utf-8',
        success: function(){},
        dataType: "json",
        contentType : "application/json"
    });


    event.preventDefault();
});