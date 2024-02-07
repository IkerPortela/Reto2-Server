<h1>API para Gestión de Aplicación de Chat para Elorrieta-Errekamari</h1>

  <p>Este proyecto consiste en una API desarrollada en Spring para la gestión de una aplicación de chat destinada a la comunidad de Elorrieta-Errekamari. La API proporciona servicios para la gestión de grupos, chats y usuarios, permitiendo acciones como la creación y eliminación de grupos, la participación de usuarios en chats, el envío de mensajes, entre otros.</p>

  <h2>Funcionalidades</h2>

  <ul>
    <li><strong>Gestión de Grupos:</strong>
      <ul>
        <li>Creación de nuevos grupos.</li>
        <li>Eliminación de grupos existentes.</li>
        <li>Eliminación de grupos existentes</li>
      </ul>
    </li>
    <li><strong>Gestión de Chats:</strong>
      <ul>
        <li>Unión de usuarios a chats.</li>
        <li>Abandono de chats por parte de los usuarios.</li>
        <li>Eliminación de usuarios del chat por parte de los profesores</li>
        <li>Envío de mensajes en los chats.</li>
      </ul>
    </li>
    <li><strong>Gestión de Usuarios:</strong>
      <ul>
        <li>Registro de nuevos usuarios.</li>
        <li>Autenticación de usuarios existentes.</li>
        <li>Actualización de información de usuario.</li>
      </ul>
    </li>
  </ul>

  <h2>Tecnologías Utilizadas</h2>

  <ul>
    <li>Spring Framework: Framework de aplicación Java que proporciona soporte integral para el desarrollo de aplicaciones empresariales.</li>
    <li>Hibernate: Framework de mapeo objeto-relacional para la gestión de datos en la base de datos.</li>
    <li>MySQL: Sistema de gestión de bases de datos relacional utilizado para almacenar los datos de la aplicación.</li>
    <li>Laravel: Framework de aplicación PHP utilizado para la generación de la base de datos.</li>
  </ul>

  <h2>Requisitos de Configuración</h2>

  <ul>
    <li>Java 8 o superior.</li>
    <li>Maven para la gestión de dependencias.</li>
    <li>Servidor MySQL instalado y configurado.</li>
    <li>Acceso a la base de datos generada por la aplicación Laravel.</li>
  </ul>

  <h2>Configuración del Proyecto</h2>

  <ol>
    <li>Clona el repositorio desde GitHub. <code>git clone git@github.com:IkerPortela/Reto2-Server.git</code></li>
    <li>Configura la conexión a la base de datos MySQL en el archivo <code>application.properties</code> ubicado en <code>src/main/resources</code>. Asegúrate de proporcionar la URL, el usuario y la contraseña correctos.</li>
    <li>Configura en la parte de la aplicación la conexión con el servidor de Spring para hacer peticiones Http a la API y la conexión con el socket para poder hacer comunicaciones entre los dispositivos</li>
    <li>Ejecuta el proyecto utilizando Maven.</li>
  </ol>

  <h2>Endpoints API</h2>

  <p>La API proporciona los siguientes endpoints:</p>

  <ul>
    <li>GET /api/auth/users: Obtiene todos los usuarios disponibles.</li>
    <li>GET /api/users/chat: Obtiene todos los chats del usuario</li>
    <li>GET /api/chats/public: Obtiene los chats públicos </li>
    <li>GET /api/messages/{chatId}: Obtiene los mensajes de un chat específico</li>
    <li>...</li>
  </ul>

  <h2>Contribución</h2>

  <p>Si deseas contribuir a este proyecto, siéntete libre de crear una bifurcación y enviar tus solicitudes de extracción. También puedes informar sobre problemas abriendo un nuevo problema en el repositorio.</p>

<h3 align="left">Lenguajes y herramientas:</h3>
<p align="left"> <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> </a> <a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> </a> <a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> </a> </p>
