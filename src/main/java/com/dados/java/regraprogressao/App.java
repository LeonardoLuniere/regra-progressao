package com.trybe.java.regraprogressao;

import java.util.Scanner;

/**
 * Esta classe representa um aplicativo para cadastrar atividades.
 */
public class App {

  /**
   * Este é o método principal que inicia o aplicativo de cadastro de atividades.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite a quantidade de atividades para cadastrar:");
    byte qtd = Byte.parseByte(scanner.nextLine());

    String[] nomes = new String[qtd];
    byte[] pesos = new byte[qtd];
    byte[] notas = new byte[qtd];

    int somaDosPesos = 0; // Variável para armazenar a soma dos pesos

    for (byte i = 0; i < qtd; i++) {
      System.out.println("Digite o nome da atividade " + (i + 1) + ":");
      nomes[i] = scanner.nextLine();

      System.out.println("Digite o peso da atividade " + (i + 1) + ":");
      pesos[i] = Byte.parseByte(scanner.nextLine());

      somaDosPesos += pesos[i]; // Adiciona o peso atual à soma dos pesos

      System.out.println("Digite a nota obtida para " + nomes[i] + ":");
      notas[i] = Byte.parseByte(scanner.nextLine());
    }

    // Verificar se a soma dos pesos é igual a 100
    if (somaDosPesos != 100) {
      System.out.println("A soma dos pesos é diferente de 100!");
    } else {
      System.out.println("A soma dos pesos é igual a 100. Foram cadastradas com sucesso.");

      // Calcular o resultado com base nas notas e pesos
      double resultado = calcularResultado(notas, pesos);

      // Verificar a aprovação ou reprovação
      if (resultado >= 85.0) {
        System.out.println("Parabéns! Você alcançou "
            + resultado + "%! E temos o prazer de informar que você obteve aprovação!");
      } else {
        System.out.println("Lamentamos informar que, com base na sua pontuação, "
            + resultado + "%, você não atingiu a pontuação mínima necessária para sua aprovação.");
      }

      System.out.println("Resumo das atividades cadastradas:");
      for (int i = 0; i < qtd; i++) {
        System.out.println("Atividade: " + nomes[i]);
        System.out.println("Peso: " + pesos[i]);
        System.out.println("Nota Obtida: " + notas[i]);
      }
    }
  }

  /**
   * Função para calcular o resultado com base nas notas e pesos.
   *
   * @param notas Notas obtidas nas atividades.
   * @param pesos Pesos das atividades.
   * @return O resultado calculado.
   */
  public static double calcularResultado(byte[] notas, byte[] pesos) {
    double somaPesosNotas = 0;
    for (int i = 0; i < notas.length; i++) {
      somaPesosNotas += (notas[i] * pesos[i]);
    }
    double somaPesos = 0;
    for (int peso : pesos) {
      somaPesos += peso;
    }
    return (somaPesosNotas / somaPesos);
  }
}
