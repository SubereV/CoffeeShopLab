$(document).ready(function () {
    var table = $('#dataTable').DataTable({
        "ajax": "/api/products",
        "columns": [
            {"data": "name"},
            {"data": "picture-element"},
            {"data": "content"},
            {"data": "price"},
            {"data": "date"},
        ],
    });
    //Bookmark: Table Row On click
    $('#dataTable tbody').on('click', 'tr', function () {
        if ($(this).hasClass('selected')) {
            $(this).removeClass('selected');
            $("#edit").attr("disabled", true);
            $("#delete").attr("disabled", true);
            $('#menu').find('option:selected').removeAttr("selected");
        } else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
            var cursor = table.row($(this));//get the clicked row
            var data = cursor.data();
            console.log(data);
            $("#edit").attr("disabled", false);
            $("#delete").attr("disabled", false);
            $("#insert_title").attr("hidden", true);
            $("#edit_title").attr("hidden", false);
            $('#modalForm').attr("action","/products/edit");
            $('#modalForm').find("input[name='name'][type='text']").val(data.name);
            $('#modalForm').find("textarea[name='content']").val(data.content);
            $('#modalForm').find("input[name='id']").val(data.id);
            $('#deleteForm').find("input[name='productId']").val(data.id);
            $('#modalForm').find("input[name='price'][type='text']").val(data.price);
            $('#modalForm').find("input[name='picture'][type='hidden']").val(data.picture);
            $('#img-preview').attr("src", data.picture);
            $('#modalForm').find("input[name='picture'][type='hidden']").val(data.picture);
            $('#menu').find('option:selected').removeAttr("selected");
            let target = '#menu option[value=\"' + data.menu + '\"]';
            $(target).attr("selected", true);
            console.log(target);
        }
    });
    //Bookmark: insert button On click
    $("#insert").click(() => {
        table.$('tr.selected').removeClass('selected');
        $("#insert_title").attr("hidden", false);
        $("#edit").attr("disabled", true);
        $("#delete").attr("disabled", true);
        $("#edit_title").attr("hidden", true);
        $('#modalForm').attr("action","/products/insert");
        $('#modalForm').find("input[name='name'][type='text']").val("");
        $('#modalForm').find("textarea[name='content']").val("");
        $('#modalForm').find("input[name='price'][type='text']").val("");
        $('#modalForm').find("input[name='picture'][type='hidden']").val("https://s7d7.scene7.com/is/image/DeluxeForms/20986?wid=800");
        $('#img-preview').attr("src", "https://s7d7.scene7.com/is/image/DeluxeForms/20986?wid=800");
        $('#menu').find('option:selected').removeAttr("selected");
    });
    //todo: delete button trigger
});
