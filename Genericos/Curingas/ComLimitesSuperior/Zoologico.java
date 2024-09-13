package Genericos.Curingas.ComLimitesSuperior;

import java.util.List;

public class Zoologico {
    public void fazerBarulho(List<? extends Animal> animais) {
        for (Animal animal: animais) {
            animal.som();
        }
    }
}
