$(document).ready(function () {
    $.ajax({
        url: '/api/film/all',
        type: 'get',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (films) {
            console.log(films);
            for (let i = 0; i < films.length; i++) {
                $("#forAdd").before("<tr>" +
                    "<td>" + films[i].id + "</td>" +
                    "<td>" + films[i].title + "</td>" +
                    "<td>" + films[i].rating + "</td>" +
                    "<td>" + films[i].age + "</td>" +
                    "<td>" +
                    " <button type=\"button\" data-toggle=\"modal\" data-target=\"#editFilm\" class=\"btn btn-info\" onclick=\"fillModal(" + films[i].id + ")\">" +
                    "        Edit this film\n" +
                    "    </button>" +
                    "<a class=\"btn btn-danger\" href=\"/films/deleteFilm?id=" + films[i].id + "\">Delete</a>" +
                    "</td>" +
                    "</tr>")
            }

        },
        error: function (response) {
            alert('error');
        }
    });
});

function addFilm() {
    var name = $("#input-name").val();
    var rating = $("#input-rating").val();
    var age = $("#input-age").val();

    var newFilm = {
        'title': name,
        'rating': rating,
        'age': age
    }
    $.ajax({
        method: "post",
        url: "/api/film/new",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(newFilm),
        success: function () {
            window.location.replace("/films/all");
        },
        error: function (error) {

        }
    });
}

function fillModal(id) {
    $.ajax({
        method: "get",
        url: "/api/film/get?id=" + id,
        contentType: "application/json; charset=utf-8",
        success: function (film) {
            console.log(film);
            $("#edit-id").val(film.id);
            $("#edit-name").val(film.title);
            $("#edit-rating").val(film.rating);
            $("#edit-age").val(film.age);
        },
        error: function (error) {

        }
    })
}
function sendData() {
    var id = $("#edit-id").val();
    var name = $("#edit-name").val();
    var rating = $("#edit-rating").val();
    var age = $("#edit-age").val();
    var editedFilm = {
        'id': id,
        'title': name,
        'rating': rating,
        'age': age
    }
    $.ajax({
        method: "post",
        url: "/api/film/new",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(editedFilm),
        success: function () {
            window.location.replace("/films/all");
        },
        error: function (error) {
            alert("Error: wrong values.");
        }
    });
}