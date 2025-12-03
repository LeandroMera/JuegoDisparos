🎮 Juego de Disparos 2D – JavaFX

Un shooter 2D desarrollado en JavaFX, donde el jugador debe esquivar enemigos, recoger mejoras, sumar puntuación y sobrevivir lo máximo posible.
Este proyecto combina programación orientada a objetos, gestión de escenas, timers, colisiones, generación de enemigos, y una arquitectura modular pensada para expandirse fácilmente.

🚀 Características principales

  👾 Generación dinámica de enemigos
  
      Enemigos que se mueven, colisionan y causan daño.
  
  🔫 Jugador con disparos
  
      Proyectiles controlados por el usuario.
  
  ⭐ Objetos de mejora (+ puntos)
  
      Aumentan la puntuación al recogerlos.
  
  ❤️ Sistema de vida
  
      La vida baja al chocar con enemigos.
  
  🧠 Gestión de escenas
  
      Menú de inicio → Juego → Pantallas.
  
  📦 Arquitectura limpia
  
      Clases separadas por responsabilidad: jugador, enemigos, objetos, UI, lógica del juego, etc.
  
  🎨 Imágenes y fondos personalizados
  
      🔄 Loop de juego fluido
  
  Actualización constante con AnimationTimer.

🧱 Arquitectura del proyecto
          src/main/java/
        └── org.gorditodev.juegodisparosdemo
            ├── utiles/
            │   ├── ConexionBBDD.java
            │   ├── ContadorTiempo.java
            │   ├── Disparo.java
            │   ├── EtPuntuacion.java
            │   ├── GestionEnemigos.java
            │   ├── GestionEscenas.java
            │   ├── GestionObjetos.java
            │   ├── ObjMejora.java
            │   ├── PJ.java
            │   ├── Puntuacion.java
            │   └── Vida.java
            │
            └── vista/
                ├── Main.java
                ├── MenuInicio.java
                ├── PanelInferior.java
                ├── PanelJuego.java
                ├── PanelPuntuaciones.java
                ├── PanelRaiz.java
                ├── HelloApplication.java
                └── HelloController.java
        
        src/main/resources/
        └── img/
            ├── fondo.png
            └── fondo2.png
🕹️ Cómo jugar

    1.- Inicia el juego desde el menú principal.
    
    2.- Mueve al personaje para evitar enemigos.
    
    3.- Dispara para destruirlos.
    
    4.- Recoge mejoras para sumar puntos.
    
    5.- Sobrevive lo más que puedas.

🛠️ Tecnologías utilizadas

  Java 17+
  
  JavaFX 21
  
  Maven (si deseas agregarlo)
  
  Programación orientada a objetos (POO)
  
  Animaciones con AnimationTimer

  👤 Autor

Proyecto desarrollado por Leandro, alias GorditoDev.
    
