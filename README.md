<h1 align="center">Projeto: Sistema de Jogo de Xadrez</h1>

#### Autor:
[![Valmir Sales](https://img.shields.io/badge/Valmir%20Sales%20Gama-gray?style=flat-square&logo=github&logoColor=white&logoWidth=20&link=https://github.com/ValmirSGama)](https://github.com/ValmirSGama)
![GitHub top language](https://img.shields.io/github/languages/top/ValmirSGama/sistemaJogoDeXadrex-Java)
![GitHub repo size](https://img.shields.io/github/repo-size/ValmirSGama/sistemaJogoDeXadrex-Java)

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
- O projeto está sem o executável(.class) que reside na pasta bin. para gerá-los, é preciso executar em uma IDE de sua escolha.
- Na segunda vez que for executar o jogo, você pode rodá-lo diretamente do diretório do mesmo, dentro da pasta 'bin', que foi gerada anteriormente pela IDE. Se você tiver o Git instalado em sua máquina, caso não tenha, você pode baixá-lo neste link: https://git-scm.com/.

#### Clonando através do Visual Studio Code (VSCode), por exemplo:

#### 1. Certifique-se de ter o VSCode instalado em sua máquina.
- Abra o Visual Studio Code.
#### 2. Abra a paleta de comandos:
- Pressione Ctrl + Shift + P (ou Cmd + Shift + P no macOS) para abrir a paleta de comandos.
#### 3. Digite "Git: Clone" na paleta de comandos:
- selecione a opção correspondente quando ela aparecer.
#### 4. Forneça o URL do repositório:
- O VSCode solicitará que você insira o URL do repositório. Cole esse URL: https://github.com/ValmirSGama/sistemaJogoDeXadrex-Java e pressione Enter.
#### 5. Escolha o diretório de destino:
- O VSCode perguntará onde você deseja salvar o repositório clonado. Selecione o diretório desejado e clique em "Selecionar Repositório de Destino".
#### 6. Abra o repositório clonado:
- Após o clone ser concluído, você pode abrir o repositório clicando no botão "Abrir" na notificação de clone concluído ou usando o explorador de arquivos no lado esquerdo do VSCode para navegar até o diretório do repositório clonado e abrir.

### Como Executar:
- Execute preferencialmente em um terminal de fundo preto, pois as cores padrão dos jogadores (preto e branco) foram modificadas, sendo uma delas alterada de preto para amarelo para proporcionar uma melhor harmonia visual. 
- Ao execulta pela segunbda vez, se preferir utilizar o terminal do git Bash, navegue até a pasta bin do projeto, dentro dela, click com o botão direito do mouse e depois escolha a opção: Open Git Bash here, então, dentro do terminal, inicie o jogo com o comando: java application/Program.

### Interface do Jogo:
![Interface do Jogo](Chess-system-class-diagram/Interface%20do%20jogo.png)

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

---

### Projeto realizado no curso de Java Completo com Nélio Alves