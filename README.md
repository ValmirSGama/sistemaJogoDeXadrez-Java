## Projeto: Sistema de Jogo de Xadrez

Este sistema foi desenvolvido aplicando os conceitos de Orientação a Objetos em Java, tais como:

- Encapsulamento
- Modificadores de acesso
- Construtores
- Métodos toString
- Object/overriding
- Associações
- Matrizes
- Enumerações
- Herança
- Downcasting e Upcasting
- Membros Estáticos
- Padrão de Camadas
- Exceções
- Classes e métodos abstratos
- Listas

### Estrutura do Projeto:

O sistema foi subdividido em quatro pacotes e dezessete classes, sendo que estas foram organizadas nos pacotes respeitando as camadas e suas características de funcionalidades. 

### Pré-requisitos:
- Java JDK (versão SE 17) ou superior.

### Configuração:

- Fazer um Fork no github ou clonar o repositório via terminal.

### Como Executar:
Execute preferencialmente no "git Bash", pois as cores padrão dos jogadores (preto e branco) foram modificadas, sendo uma delas alterada de preto para amarelo para proporcionar um melhor contraste visual com o fundo preto do terminal. Abra o terminal do git Bash ao estar dentro da pasta bin do projeto e inicie o jogo com o comando: java application/Program

### Funcionalidades:
O jogo conta com todas as funcionalidades básicas do xadrez, incluindo os movimentos especiais como Castling, En Passant e Promotion. O tabuleiro foi programado para mostrar em azul as possíveis jogadas de cada peça quando acionada. Os jogadores podem ser identificados pelas iniciais do nome em inglês, tais como:

- "P" de Pawn/Peão
- "B" de Bishop/Bispo
- "C" de Knight ou Cavalier/Cavaleiro
- "Q" de Queen/Rainha
- "K" de King/Rei
- "R" de Rook/Torre

### Definição dos movimentos especiais:

#### Castling (Roque):

- O castling é um movimento especial que envolve o rei e uma torre. Para realizar o castling, as seguintes condições devem ser atendidas:
- O rei e a torre envolvida na jogada não devem ter se movido anteriormente.
- Não deve haver peças entre o rei e a torre.
- O rei não pode estar em xeque.
- O rei não pode atravessar ou terminar em uma casa atacada por uma peça adversária.

#### En Passant:

- O en passant é uma jogada especial envolvendo peões. Se um peão avança duas casas a partir de sua posição inicial e "pousa" ao lado de um peão adversário, o peão adversário tem a opção de capturá-lo como se tivesse avançado apenas uma casa.
- Essa jogada só é válida imediatamente após o peão avançar duas casas.

#### Promotion (Promoção):

- A promoção ocorre quando um peão alcança a oitava (última) fileira do tabuleiro adversário.
- Nesse momento, o peão é promovido a qualquer peça de escolha do jogador (exceto um rei).
- A escolha geralmente é entre uma rainha, torre, bispo ou cavalo.
- A promoção permite que peões atinjam seu potencial máximo, já que eles podem se transformar em peças mais poderosas.
