# Airport Project
*Por Cauã Grigolatto Domingos (AQ3022323)*

## Sobre o Projeto
O **Airport Project** é uma aplicação para o gerenciamento de voos em um aeroporto, oferecendo as seguintes funcionalidades:
a
- **Cadastro de voos**
- **Atualização do status dos voos**
- **Exibição de informações sobre os voos**
- **Filtragem de voos por status** em formato de totens

Além disso, o projeto implementa diversos **padrões de projeto**, que permitiram a construção de um código limpo, escalável e reutilizável, sendo eles:

- **Observer**: Para manter atualizados os totens de cada status de voo.
- **State**: Para representar o estado atual de um voo.
- **Singleton**: Para garantir a criação de objetos com uma única instância.
- **Front Controller**: Para centralizar as requisições e dispatches.
- **Command**: Para processar as requisições e retornar as páginas apropriadas.
- **Model-View-Controller (MVC)**: Para separar as entidades do sistema (models), as páginas (views) e as classes que manipulam os requests e responses (controllers).

### Funcionalidades do Sistema

1. **Sistema de autenticação por login**
	Utilizando o username "admin" e a senha "admin", é possível logar no sistema e acessar as funcionalidades de um administrador.
	
	![Login input wrong credentials](./screenshots/login-1)
	
	![Login error message](./screenshots/login-2)
	
	![Login input correct credentials](./screenshots/login-3)
	
	![Login success message](./screenshots/login-4)
	
2. **Cadastro de voos**
	O cadastro de voos no sistema é realizado apenas na memória, simulando a inserção de dados em um banco de dados. Apenas administradores logados no sistema podem cadastrar voos.

	![Insertion input](./screenshots/creation-1)
	
	![Insertion success message](./screenshots/creation-2)
	
	![Insertion input repeated value](./screenshots/creation-3)
	
	![Insertion error message](./screenshots/creation-4)

3. **Gerenciamento do status de cada voo**  
	Esta funcionalidade implementa o padrão **State**, permitindo que o status de um voo seja alterado conforme sua progressão (por exemplo, de *Arriving* para *Boarding*). Apenas administradores podem alterar o status, e é necessário estar logado para acessar essa funcionalidade.

	![Update state before](./screenshots/update-1)
	
	![Update state after](./screenshots/update-2)

4. **Lista de voos por status**  
	Utilizando o padrão **Observer**, o sistema mantém os totens atualizados, com uma lista de voos de cada status. Qualquer usuário, logado ou não, pode consultar os totens e obter informações sobre os voos disponíveis.

	![Login](./screenshots/list-1)
	
	![Login](./screenshots/list-2)
	
	![Login](./screenshots/list-3)

5. **Logout e revogação das permissões**
	Ao fazer logout, o usuário está impedido de cadastrar voos ou atualizar seus status.
	
	![Logout error message action](./screenshots/logout-1)
	
	![Logout error message page access](./screenshots/logout-2)

## Padrões de Projeto

Os **padrões de projeto** (ou **design patterns**) são soluções comprovadas para problemas recorrentes no desenvolvimento de software. Eles proporcionam uma abordagem estruturada para resolver desafios comuns, promovendo boas práticas, aumentando a escalabilidade e facilitando a manutenção do código.

A seguir, serão discutidos os principais padrões utilizados no **Airport Project** e como cada um contribui para a construção de um sistema organizado e eficiente.

### Observer
O padrão **Observer** estabelece uma relação de dependência entre objetos, onde um objeto (sujeito) notifica automaticamente outros objetos dependentes (observadores) sobre mudanças em seu estado. No **Airport Project**, os totens de status de voo são implementados como observadores, atualizando suas listas conforme a inserção ou atualização de voos. Cada totem mantém uma lista de voos de um estado específico, que é atualizada sempre que um voo entra ou sai de um determinado estado.

### State
O padrão **State** permite que um objeto altere seu comportamento dinamicamente com base em seu estado interno. No projeto, os voos possuem diferentes estados (por exemplo, *Arriving*, *Boarding*, *TakingOff*, *TookOff*), e a cada atualização de estado, o comportamento do voo é modificado de acordo com a transição entre esses estados. Esse padrão é usado para garantir que cada voo mude de estado de forma controlada e organizada.

### Singleton
O padrão **Singleton** garante que uma classe tenha apenas uma instância global, evitando a criação de múltiplos objetos desnecessários. No **Airport Project**, o **Singleton** foi utilizado para garantir que as classes de estado (State) tivessem apenas uma instância acessível, evitando a sobrecarga de criação de novos objetos de estado e otimizando o desempenho.

### Front Controller
O **FrontController** centraliza o gerenciamento de requisições, redirecionando-as para os controladores apropriados. No **Airport Project**, uma única servlet recebe todas as requisições e as delega para as classes corretas, garantindo que o sistema fique mais organizado e as requisições sejam tratadas de maneira eficiente.

### Command
O padrão **Command** trabalha em conjunto com o **FrontController**. Quando o FrontController recebe uma requisição, ela é passada para a classe **Command** responsável. Essa classe processa a requisição e retorna a página (view) apropriada. O **Command** isola o processamento de requisições, tornando o código mais modular e organizado.

### Model-View-Controller (MVC)
O padrão **MVC** divide a aplicação em três camadas distintas:

- **Model**: Entidades e dados do sistema (como voos e estados).
- **View**: Interface de usuário (as páginas que o usuário interage).
- **Controller**: Controla o fluxo da aplicação, manipulando os dados (model) e direcionando as páginas de resposta (views).

Esse padrão promove a separação de responsabilidades, facilitando a manutenção, a reutilização e a escalabilidade da aplicação.

## Tecnologias e Recursos Utilizados

- **Java EE**: Plataforma de desenvolvimento Java que forneceu diversas APIs necessárias para a construção do sistema, como **Servlets** para tratamento de requisições.
- **Maven**: Gerenciador de dependências responsável por organizar bibliotecas externas e facilitar o processo de build e deploy.
- **JavaServer Pages (JSP)**: Tecnologia utilizada para criar páginas dinâmicas em Java, incorporando código Java diretamente em HTML para gerar conteúdo baseado nas requisições do usuário.
- **Bootstrap**: Framework CSS utilizado para estilizar e garantir que as páginas sejam responsivas, adaptando-se a diferentes dispositivos e resoluções de tela.
- **Javadoc**: Ferramenta utilizada para gerar documentação técnica do código, descrevendo as classes, métodos e interfaces do sistema, facilitando a manutenção e o entendimento por outros desenvolvedores.

