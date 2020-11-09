$(document).ready(function () {
    var table = $('#dataTable').DataTable({
        "ajax": "/api/menu",
        "columns": [
            {"data": "name"},
            {"data": "description"},
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
            $('#deleteForm').find("input[name='productId']").val(data.id);
            $('#modalForm').attr("action","/menu/edit");
            $('#modalForm').find("input[name='name'][type='text']").val(data.name);
            $('#modalForm').find("textarea[name='description']").val(data.description);
            $('#modalForm').find("input[name='id']").val(data.id);
        }
    });
    //Bookmark: insert button On click
    $("#insert").click(() => {
        table.$('tr.selected').removeClass('selected');
        $("#insert_title").attr("hidden", false);
        $("#edit").attr("disabled", true);
        $("#delete").attr("disabled", true);
        $("#edit_title").attr("hidden", true);
        $('#modalForm').attr("action","/menu/insert");
        $('#modalForm').find("input[name='name'][type='text']").val("");
        $('#modalForm').find("textarea[name='description']").val("");
    });
    //todo: delete button trigger
});
