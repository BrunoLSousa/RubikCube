# RubikCube

RubikCube - *Cubo mágico (3x3)*

Trabalho da disciplina Computação Natural - UFMG

##Objetivo 

O objetivo desse trabalho é utilizar o algoritmo genético para resolver o cubo mágico, a partir de um dado estado. Com isso, 
busca-se uma solução que aproxime-se da solução ótima por meio da evolução de n populações, nas quais estão representadas 
possíveis soluções do espaço de busca do problema.

##Informações importantes sobre o Algoritmo Génetico

###Modelagem
  - **1. Cromossomo:**
     - 1.1. Genótipo: representa uma sequência de possíveis movimentos que serão aplicadas ao cubo para uma possível resolução do mesmo.
     - 1.2. Fenótipo: representa o estado final do cubo após a aplicação da sequência de movimentos (genótipo).
  - **2. Operadores:**
     - **1.1. Cruzamento:** foi utizado um cruzamento de ponto para este algoritmo com uma probabilidade de 30%.
     - 1.2. Mutação: foi utilizado uma mutação uniforme para este algoritmo com uma probabilidade de 15% para escolha de 
            um indivíduo e 15% para escolha de um gene.
     - 1.3. Seleção: foi utilizado o método de seleção por torneio de tamanho 3 (k=3).
     - 1.4. Elitismo: a cada nova geração é selecionado o melhor indivíduo da população antiga e inserido na nova.
  - **3. População:** a cada geração o algoritmo possui uma população composta por 1.500 indivíduos.
  - **4. Geração:** o algoritmo evolui as soluções durante 1.000 gerações.


###Funcionamento do Algoritmo
  -1. Uma população inicial é criada com um total de 1.500 indivíduos.
  -2. O genótipo e fenótipo de cada indivíduo são combinados e o valor da fitness é calculado através de uma penalização 
      dos quadrados, bordas e quinas posicionadas de forma errada.
  -3. Uma nova população é criada através da inserção do indivíduo de melhor fitness da população anterior.
  -4. Os indivíduos da população anterior passam por um torneio e os dois indivíduos selecionados passam por um processo
      avaliação de cruzamento, na qual define se ambos podem ser cruzados os não. Em caso positivo, dois novos filhos são
      gerados e ambos, juntamente com os pais são inseridos na nova população. Em caso negativo, apenas os pais são inseridos
      na nova população. Esse processo se repete até que a população seja completada.
  -5. Os novos invíduos, com exceção do elitista, passa por um processo de avaliação de mutação, no qual é definido se um 
      indivíduo i pode sofrer mutação ou não. Em caso positivo, cada gene pertencente ao indivíduo i passa por uma avaliação
      que define se este será trocado por algum outro gene. Essa troca ocorre de forma aleatória. Esse processo se repete até 
      o último indivíduo desta população.
  -6. Os passos 2, 3, 4 e 5 são repetidos até que o critério de parada (quantidade de gerações <= 1000) seja satisfeito.
  -7. Quando o critério de parada é satisfeito, o algoritmo finaliza sua execução mostrado uma gráfico de convergência durante 
      o processo de evolução, os valores dos melhor indivíduos de cada geração e a sequência de movimentos junto com o estado 
      final do cubo.

###Documentação

   Para mais informações e detalhes sobre o funcionamento do algoritmo, experimentos e testes, consulte arquivo "Documentação do Trabalho.pdf"
 dentro da pasta documentation, situada dentro da raiz do projeto.

## Manual de Instalação

Para fazer a instalação do programa, siga os seguintes passos:

* Faça download do projeto compactado no link: https://github.com/BrunoLSousa/RubikCube.git ;

* Faça a extração do arquivo compactado em sua máquina;

* Abra o projeto no programa Netbeans 8.0.2 com a jdk 1.7;

* Limpe-o e construa para que seje gerado uma pasta chamada dist dentro da pasta do projeto;

* Pronto. O programa está instalado.

## Manual de Execução do programa

Para executar o programa, siga os seguintes passos:

* Abra o terminal do Linux e vá para a pasta script dentro da pasta do projeto extraída 
utilizando o comando cd (digite: cd "nome_do_diretorio" e pressione enter);

* Execute o seguinte comando: ./executar.sh "nome do arquivo de entrada" "nome do arquivo de saída". Ex.: ./executar in1 out1.
  Obs.: Ao indicar o arquivo de entrada para o programa, certifique-se que o nome do arquivo ou diretório do mesmo está correto. 
  Além disso, certifique-se de que o arquivo fornecido como entrada possui o padrão correto especificado na documentação (ver Seção 4.2 da documentação).

* Pronto. Programa executado.
