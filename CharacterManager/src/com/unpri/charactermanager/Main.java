
package com.unpri.charactermanager;

import java.util.ArrayList;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.manager.CharacterManager;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        // Menambahkan empat karakter
        manager.addCharacter(
            new Character("Aragorn", CharacterType.WARRIOR, 5)
        );
        manager.addCharacter(
            new Character("Merlin", CharacterType.MAGE, 8)
        );
        manager.addCharacter(
            new Character("Legolas", CharacterType.ARCHER, 4)
        );
        manager.addCharacter(
            new Character("Aurora", CharacterType.HEALER, 3)
        );

        System.out.println("=== DAFTAR KARAKTER ===");
        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }

        // Pengujian duplikat nama
        System.out.println("\n=== UJI DUPLIKAT ===");
        boolean result = manager.addCharacter(
            new Character("aragorn", CharacterType.MAGE)
        );
        System.out.println("Berhasil ditambahkan: " + result);

        // Pengujian pencarian
        System.out.println("\n=== CARI KARAKTER ===");
        Character found = manager.findByName("Merlin");
        System.out.println(found);

        // Pengujian rata-rata level
        System.out.println("\n=== RATA-RATA LEVEL ===");
        System.out.println("Rata-rata: " + manager.getAverageLevel());

        CharacterManager emptyManager = new CharacterManager();
        System.out.println(
            "Rata-rata list kosong: " + emptyManager.getAverageLevel()
        );

        // Pengujian tipe karakter
        System.out.println("\n=== KARAKTER WARRIOR ===");
        ArrayList<Character> warriors =
            manager.findByType(CharacterType.WARRIOR);

        for (Character c : warriors) {
            System.out.println(c.getName());
        }

        // Fitur tambahan findStrongest
        System.out.println("\n=== KARAKTER TERKUAT ===");
        Character strongest = manager.findStrongest();

        if (strongest != null) {
            System.out.println(
                strongest.getName() + ", attack: " + strongest.getAttack()
            );
        }

        // Pengujian salinan list
        System.out.println("\n=== UJI SALINAN LIST ===");
        ArrayList<Character> copy = manager.getAllCharacters();
        copy.clear();

        System.out.println("Jumlah di salinan: " + copy.size());
        System.out.println(
            "Jumlah di manager: " + manager.getTotalCharacters()
        );

        // Pengujian reference
        System.out.println("\n=== UJI REFERENCE ===");
        Character a = new Character("Test", CharacterType.MAGE);
        Character b = a;
        b.setLevel(8);

        System.out.println("Level a: " + a.getLevel());
        System.out.println("a == b: " + (a == b));

        // Pengujian hapus karakter
        System.out.println("\n=== UJI HAPUS ===");
        System.out.println(
            "Aragorn dihapus: " + manager.removeCharacter("Aragorn")
        );
        System.out.println(
            "Jumlah karakter sekarang: " + manager.getTotalCharacters()
        );

        System.out.println(
            "Total objek dibuat: " + Character.getTotalCharacterCreated()
        );
    }
}
