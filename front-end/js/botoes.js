document.querySelector('#btn-novo').addEventListener('click', function () {
    location.assign('novo.html');
});

document.addEventListener('click', function (event) {
    if (event.target.matches('.btn-excluir')) {
        const id = event.target.id;
        fetch(`http://localhost:8080/usuarios/${id}`, {
            method: 'DELETE'
        });
        location.reload();
    }
});

document.addEventListener('click', function (event) {
    if (event.target.matches('.btn-alterar')) {
        const id = event.target.id;
        window.location.href = `alterar.html?id=${id}`;
    }
});