# Arquitectura MVC con Observer

En esta rama utilizaremos el patrón Observer

Los cambios de la velocidad que se hagan en el model
serán observados por el Controller

Para notificar a los observadores hacemos dos pasos

* Actualizamos el estado a 'algo a cambiado' con `setChanged()`
* Notificamos a los observadores `notifyObservers(valor)`

De esta manera se *dispara* en todos los observadores el método `update()`

---
## Diagrama de clases:

```mermaid
classDiagram
    class Observable {
        }
        class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller{
          +main()
      }
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +cambiarVelocidad(String, Integer)
          +getVelocidad(String)
      }
      class ObserverVelocidad {
          +update()
          }
          Controller "1" *-- "1" ObserverVelocidad: association
          Controller "1" *-- "1" Model : association
    Model "1" *-- "1..n" Coche : association
    Observable <|-- Model
      
```

---

## Diagrama de Secuencia

Que ocurre cuando se cambia la velocidad


```mermaid
sequenceDiagram
    participant View
    participant Controller
    participant ObserverVelocidad
    participant Model
    
    Controller->>Model: cambia la velociad, porfa
    activate Model
    Model->>ObserverVelocidad: Notificacion de cambio de velocidad
    deactivate Model
    activate ObserverVelocidad
    ObserverVelocidad->>+View: Muestra la velocidad, porfa
    deactivate ObserverVelocidad
    activate View
    View->>-View: Mostrando velocidad
    deactivate View
```

El mismo diagrama con los nombres de los métodos

```mermaid
sequenceDiagram
    participant View
    box gray Controlador
    participant Controller
    participant ObserverVelocidad
    end
    participant Model

    Controller->>Model: cambiarVelocidad()
    activate Model
    Model->>ObserverVelocidad: update()
    deactivate Model
    activate ObserverVelocidad
    ObserverVelocidad->>+View: muestraVelocidad
    deactivate ObserverVelocidad
    activate View
    View->>-View: sout
    deactivate View
```

Si sumamos otro observador, entonces el `update()` será en paralelo (**par**)

a todos los Observadores

```mermaid
sequenceDiagram
    participant View
    box gray Controlador
    participant Controller
    participant ObserverVelocidad
    participant ObserverOtro
    end
    participant Model

    Controller->>Model: cambiarVelocidad()
    activate Model
    par notificacion
        Model->>ObserverVelocidad: update()
    and notificacion
        Model->>ObserverOtro: update()
        end
    deactivate Model
    activate ObserverVelocidad
    activate ObserverOtro
    ObserverVelocidad->>+View: muestraVelocidad
    deactivate ObserverVelocidad
    ObserverOtro->>-ObserverOtro: sout
    activate View
    View->>-View: sout
    deactivate View
```