function deleteW(endpoint, id) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        console.log(endpoint);
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            if (res.status === 204) {
                let d = document.getElementById(`warehouse${id}`);
                d.style.display = "none";
            } else
                alert("Something Wrong!");
        });
    }
}

