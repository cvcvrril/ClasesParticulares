package org.example.dao.data;

import org.example.domain.model.Album;
import org.example.domain.model.Artista;
import org.example.domain.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class StaticLists {

    public static final List<Artista> listaArtistas = new ArrayList<>(List.of(
            new Artista(1, "Extremoduro", "España"),
            new Artista(2, "Mägo de Oz", "España"),
            new Artista(3, "Rosendo", "España"),
            new Artista(4, "Soda Stereo", "Argentina"),
            new Artista(5, "MGMT", "Estados Unidos"),
            new Artista(6, "Dover", "España"),
            new Artista(7, "Bôa", "Reino Unido"),
            new Artista(8, "Gorillaz", "Reino Unido")
    ));

    public static final List<Album> listaAlbumes = new ArrayList<>(List.of(
            new Album(1, 1, new ArrayList<>(), "")
    ));

    public static final List<Usuario> listaUsuarios = new ArrayList<>(List.of(
            new Usuario(1, "root", "root")));

}
