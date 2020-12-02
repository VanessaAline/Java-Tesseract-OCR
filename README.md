# Java-Tesseract-OCR

<h1>Objetivo</h1>

Esse repositório foi criado com objetivo didático. Nele contém um projeto que será ultizado como base para nota da disciplina de Sistemas MultiMídias.

<h1>Passo a Passo</h1>
Ao executar o projeto será feito um print da tela atual que será guardado em um Buffer de Imgem onde o mesmo será adicionado a uma tela onde é possível navegar com um Scroll;<br>
Ao movimentar o mouse sobre a área que desejamos selecionar será possível visualizar as coordenadas do mouse;<br>
Ao usar o mouse para marcar a região desejada visuaizamos na tela as coordenadas da área selecionada;<br>
Em seguida basta clicar no botão "OK" que a região selecionada será salva em uma pasta do projeto onde será feita a leitura dessa imagem com o uso do Tesseract-OCR;<br>
O resultado é printado no console da sua IDE.

<h1>Sobre</h1>
O projeto usa o OCR que é um acrônimo para Optical Character Recognition ou Reconhecimento Ótico de Caracteres em português. Esta tecnologia possibilita que caracteres em uma imagem ou mapa de bits sejam reconhecidos sem necessidade de intervenção humana, ou seja, ela é capaz de extrair informações a partir de uma imagem qualquer.
Nesse projeto iremos trabalhar com a API Tesseract própria para reconhecimento de caracteres e provavelmente uma das mais conhecidas nesta área. O Tesseract trabalha em conjunto com a biblioteca Leptonica, que ajuda o mesmo a realizar a manipulação sobre imagens, realizando transformações, rotações e muitas outras operações que o Tesseract deixa por conta do Leptonica.

<h1>Links</h1>
Todo o material apresentado aqui é facilmente encontrado fazendo simples buscas utilizando o Google. 
Nesta sessão será disponibilizada os links utilizados como auxílio para desenvolvimento do projeto. 

<ol>
  <li>http://tess4j.sourceforge.net/usage.html</li>
  <li>https://www.geeksforgeeks.org/tesseract-ocr-with-java-with-examples/</li>
  <li>https://ivanqueiroz.dev/2020/07/2020-08-30-ocr-java-tesseract-tess4j.html</li>
  <li>https://stackoverflow.com/questions/11006496/select-an-area-to-capture-using-the-mouse</li>
  <li>https://www.devmedia.com.br/capturando-screenshots-em-java/2375</li>
  <li>http://tess4j.sourceforge.net/usage.html</li>
</ol>  

<h1>Dependencia</h1>

Nesse projeto fizemos uso de dependencias para falicitar a compilação do código, o empacotamento (JAR), reforçar boas práticas de desenvolvimento entre outros motivos, para isso utilizamos a ferramente Maven, sobre a qual pode ser consultada nos link a seguir:

<ol>
  <li>http://luizricardo.org/2014/06/instalando-configurando-e-usando-o-maven-para-gerenciar-suas-dependencias-e-seus-projetos-java/</li>
  <li>https://mvnrepository.com/artifact/net.sourceforge.tess4j/tess4j/4.5.4</li>
</ol> 
