window.addEventListener('load', function () {
    fetch('http://127.0.0.1:8080/usuarios')
      .then(response => response.json()) // Baixa o JSON do endpoint GET
      .then(dados => {
        const tableBody = document.querySelector('tbody');

        // Criação da tabela, cada botão tem um ID do usuário correspondente a linha dele
        dados.forEach(usuario => {
          const linha = document.createElement('tr');
          linha.innerHTML = `
                <th scope="row">${usuario.id}</th>
                <td>${usuario.nome}</td>
                <td>${usuario.cpf}</td>
                <td>${usuario.dataNascimento ? usuario.dataNascimento.split('-').join('/') : ''}</td>
                <td>${usuario.sexo}</td>
                <td id="fotosTabela"><img src="${usuario.fotoUrl}" alt="" class="foto" id="gato"></td>
                <td><button class="btn-alterar" id="${usuario.id}">a</button><button class="btn-excluir" id="${usuario.id}">x</button></td>
            `;
          tableBody.appendChild(linha); // incrementa mais 1 linha
        });
      });
  });