
- Administradores
  - O primeiro usuário cadastrado será o administrador do sistema
  - Somente o administrador pode criar outro administrador
  - O administrador deve aprovar o registro de um novo usuário
  - Os administradores podem enviar mensagens/notificações para outros usuários

- Usuários
  - Usuários **não cadastrados** podem se registrar
  - Os usuários devem acessar ao sistema através de **login** e **senha**
  - Usuários podem receber mensagens/notificações

- Mensagens/Notificações
  - Quando um usuário acessar a mensagem, a mesma deve ser marcada como **lida**

- Logs
  - Devem aceitar vários tipos de saída (csv, json)
  - Devem ser registrados quando ocorrer os seguintes eventos
    - Inclusão, alteração ou exclusão de usuários;
    - Envio de notificações;
    - Leitura de notificações;
    - Alteração de senha;
    - Autorização de usuário.
  - Formatos
    - Em caso de sucesso: `<OPERACAO>: <<NOME>>, (<<DATA>>, <<HORA>>, e <<USUARIO>>)`
    - Em caso de falha: `<<MENSAGEM DA FALHA>> ao realizar a <OPERACAO> do usuário <<NOME>>, (<<DATA>>, <<HORA>>, e <<USUARIO>>.`

- Rodapé do sistema
  - Usuário logado
  - Tipo de usuário logado
  - Botão de notificações

- Telas e Estados
  - Menu
    - Administrador
    - Usuário
  - Forms
    - Entrar
    - Registrar
    - Editar (adm)
    - Editar (usuário)
    - Notificar
  - Manter Usuário
  - Notificações

- Dimensões das Telas
  - Tamanhos
    - Janela
      - Resolução `800x600`
    - Tela Central
      - Pading `10`
    - Fontes
      - Título `30`
      - Texto `15`
      - Tabelas
        - Título `20`
        - Texto `15`
      - Botões
        - Altura `30`
        - Texto `15`
        - Largura - maior entre os elementos (se o maior botão tem 120 de largura, todos os outros botões, dessa tela, devem ter 120 de largura)
      - Forms
        - Altura `30`
        - Texto `15`
        - Largura - o maior possível (todos devem ter o mesmo tamanho de acordo com a tela atual)
