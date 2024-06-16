package Entities;
import MapSettings.PacMap;

public interface ImprovementAdapter {

    default void adapt(PacMan pacman){}
    default  void adapt(){}
    default void adapt(PacMap pacMap){}
}
