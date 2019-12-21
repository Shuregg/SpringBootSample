function newProduct(id) {
    $.ajax({
        url: '/products/editProduct?id=' + id,
        type: 'get',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function () {
            $("#newProduct").(
                <!-- Modal -->
                <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                ...
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="Cancel">Close</button>
                                    <button type="button" class="btn btn-primary">Save changes</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            )
        }
    })
}

function deleteProduct(id) {

}

$(document).ready(function () {
    $.ajax({
        url: '/api/products/all',
        type: 'get',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (products) {
            console.log(products);
            for (let i = 0; i < products.length; i++) {
                $("#forAdd").before("<tr>" +
                    "<td>" + products[i].id + "</td>" +
                    "<td>" + products[i].name + "</td>" +
                    "<td>" + products[i].price + "</td>" +
                    "<td>" + products[i].amount + "</td>" +
                    "<td>" +
                    "<a id='editBTN' class=\"btn btn-info\" data-toggle=\"modal\" data-target=\"#exampleModalCenter\" onclick='editProduct()'>Edit</a>" +
                    "<a id='deleteBTN' class=\"btn btn-danger\" onclick='deleteProduct()'>Delete</a>" +
                    "</td>" +
                    "</tr>")
            }

        },
        error: function (response) {
            alert('error');
        }
    });
});