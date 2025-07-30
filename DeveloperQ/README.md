# UserForm - Aplicación Android con Jetpack Compose

## Descripción
Aplicación Android desarrollada en Kotlin que presenta un formulario de datos de usuario con las siguientes características:

- **Jetpack Compose** para la interfaz de usuario
- **Material Design 3** para el diseño
- **Gradle DSL Kotlin** para la configuración del proyecto
- **Animaciones fluidas** en la presentación de elementos
- **Formulario completo** con foto de perfil, nombre, correo y pasatiempos

## Características principales

### 🎨 Interfaz de Usuario
- Diseño moderno con Material Design 3
- Tema adaptable (claro/oscuro)
- Animaciones de entrada suaves para cada elemento
- Interfaz responsive y accesible

### 📝 Formulario de Usuario
- **Foto de perfil**: Imagen circular con opción de cambiar URL
- **Nombre**: Campo de texto para el nombre del usuario
- **Correo electrónico**: Campo para dirección de email
- **Pasatiempos**: Campo de texto multilínea para hobbies

### ✨ Animaciones
- Animación de deslizamiento vertical para cada sección
- Efecto de fade-in progresivo
- Animación de escala en el botón al guardar
- Mensaje de confirmación animado

### 🛠️ Tecnologías utilizadas
- **Kotlin** como lenguaje principal
- **Jetpack Compose** para UI declarativa
- **Material Design 3** para componentes
- **Coil** para carga de imágenes
- **Gradle Kotlin DSL** para configuración

## Estructura del proyecto

```
app/
├── src/main/
│   ├── java/com/example/userform/
│   │   ├── MainActivity.kt
│   │   ├── UserFormScreen.kt
│   │   └── ui/theme/
│   │       ├── Theme.kt
│   │       └── Type.kt
│   ├── res/
│   │   ├── values/
│   │   │   ├── strings.xml
│   │   │   └── themes.xml
│   │   └── xml/
│   └── AndroidManifest.xml
└── build.gradle.kts
```

## Cómo ejecutar

1. Abre el proyecto en Android Studio
2. Sincroniza el proyecto con Gradle
3. Ejecuta la aplicación en un dispositivo o emulador Android (API 24+)

## Funcionalidades

- **Cambio de foto**: Toca la imagen de perfil para ingresar una nueva URL
- **Validación visual**: Los campos muestran hints y labels claros
- **Guardado**: El botón "Guardar" muestra un mensaje de confirmación
- **Scroll**: La pantalla es desplazable para dispositivos pequeños

## Requisitos del sistema

- Android Studio Arctic Fox o superior
- SDK de Android 24 (Android 7.0) o superior
- Kotlin 1.9.10
- Gradle 8.4