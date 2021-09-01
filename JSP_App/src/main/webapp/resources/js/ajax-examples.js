function ajaxWithoutJQuery(context) {
    var xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === XMLHttpRequest.DONE) {   // XMLHttpRequest.DONE == 4
            if (xmlhttp.status === 200) {
                document.getElementById("ajax-target").innerHTML = xmlhttp.responseText;
            } else if (xmlhttp.status === 400) {
                alert('Error 400');
            } else {
                alert('Error maybe from server');
            }
        }
    };

    xmlhttp.open("GET", context + "/ajax/ajax-response.jsp", true);
    xmlhttp.send();
}

function ajaxWithJQuery(context) {
    $.ajax({
        type: 'GET',
        url: context + "/ajax/ajax-servlet",
        success: function (result) {
            $('#ajax-target').html(result);
        }
    }).fail(function ( jqXHR, textStatus, errorThrown) {
        alert("error");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
}

function openDetailsModal(context, id) {
    $.ajax({
        type: 'GET',
        url: context + "/calc/details-servlet-ajax?id=" + id,
        success: function (result) {
            $('#modal-content').html(result);
            $('#myModal').modal('show');
        }
    }).fail(function ( jqXHR, textStatus, errorThrown) {
        alert("error");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
}