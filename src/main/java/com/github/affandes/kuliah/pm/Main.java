package com.github.affandes.kuliah.pm;

import java.util.Stack;
import java.util.Scanner;

class BrowserHistory {
    private Stack<String> history;

    public BrowserHistory() {
        history = new Stack<>();
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("History Browser kosong"); //
            return;
        }

        System.out.println("==========================================");
        System.out.println("\nHistory Browser Saat Ini:");
        Stack<String> tempStack = new Stack<>();


        while (!history.isEmpty()) {
            tempStack.push(history.pop());
        }

        int index = 1;
        while (!tempStack.isEmpty()) {
            String website = tempStack.pop();
            System.out.println(index + ". " + website);
            history.push(website);
            index++;
        }
    }


    public void browse(String website) {
        history.push(website);
        System.out.println("Mengakses website: " + website);
    }


    public void back() {
        if (history.isEmpty()) {
            System.out.println("Tidak bisa kembali, history kosong");
            return;
        }

        String currentWebsite = history.pop();
        System.out.println("Kembali dari  : " + currentWebsite);

        if (!history.isEmpty()) {
            System.out.println("Ke website    : " + history.peek());
        } else {
            System.out.println("Tidak ada website sebelumnya");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BrowserHistory browser = new BrowserHistory();


        System.out.println("Masukkan 3 url website untuk diakses:");
        for (int i = 1; i <= 3; i++) {
            System.out.print("Website " + i + ": ");
            String website = scanner.nextLine();
            browser.browse(website);
        }


        browser.view();

        // Test back pertama
        System.out.println("\nMengakses Fungsi Back Untuk Kembali Ke browser Sebelumnya:");
        browser.back();


        browser.view();


        System.out.println("\nMencoba fungsi back lagi untuk kembali ke awal Histori:");
        browser.back();

      //view terakhr
        browser.view();
    }
}