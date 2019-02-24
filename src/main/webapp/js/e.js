function getSearch() {
    $(".gridSearch").click(function () {
        var v = $(this).parent().find(".autoComplete").val();
        alert(v);
    });
}

function getTree() {
    $("#mytree").tree({
        url: "getTree.action",
        animate: true,
        onDblClick: function (node) {
            $(this).tree("toggle", node.target);
        },
        onClick: function (node) {
            if (node.id == 113) {
                act(2);
            } else if (node.id == 112) {
                act(1);
            } else if (node.id == 111) {
                act(0);
            }
        }

    });
}

function act(n) {
    $("#tabs").tabs("option", "active", n);
}


