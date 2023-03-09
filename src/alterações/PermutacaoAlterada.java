package alterações;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutacaoAlterada {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Bem-vindo(a), a calculadora de permutações simples da B3!!!");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Vamos agora validar se os números inseridos são válidos para esta operação: ");
        System.out.println(" ");

        //Altere os números aqui
        Integer numbersForPermutation[] = {1, 2, 3,4,5};

        // Validando se os números do array estão entre 0 <= array [i] <= 100
        boolean invalidNumbersFound = false;
        for (Integer numbers : numbersForPermutation) {
            if (numbers >= 0 && numbers <= 100) {
                continue;
            } else if (numbers >= 101) {
                invalidNumbersFound = true;
            }
        }

        if (invalidNumbersFound) {
            System.err.println("Infelizmente encontramos um erro: Tente digitar apenas números entre 0 e 100 em sua lista.");
            return;
        }

        // Validando se a quantidade de indices é maior que 10
        if (numbersForPermutation.length > 10) {
            System.err.println("Infelizmente encontramos um erro: A lista deve ter no máximo 10 elementos.");
            return;
        }

        System.out.println("Parabéns! Os números que você escolheu e a quantidade estão corretas.");
        System.out.println(" ");
        System.out.println("Vamos agora conferir o resultado da sua permutação: ");
        System.out.println(" ");

        //chamada ao método permute com o array numbersForPermutation
        permute(numbersForPermutation);

        System.out.println(" ");
        System.out.println("Obrigado por escolher a calculadora de permutações simples da B3!");
    }

    // o metodo permute cria 2 listas - remaning que tenho o array numbers. e permutation
    // que esta vazia. E passa essas listas para a função permuteHelper
    public static void permute (Integer[]numbers){
        List<Integer> remaining = new ArrayList<Integer>(Arrays.asList(numbers));
        List<Integer> permutation = new ArrayList<Integer>();
        permuteHelper(remaining, permutation);
    }

   // No permuteHelper é onde ocorre a adicição de elementos a lista permutation e forma recursiva
    public static void permuteHelper (List < Integer > remaining, List < Integer > permutation){
        if (remaining.size() == 0) {
            System.out.println(permutation);
        } else {
            for (int i = 0; i < remaining.size(); i++) {
                Integer element = remaining.get(i);
                permutation.add(element);
                remaining.remove(i);
                permuteHelper(remaining, permutation);
                permutation.remove(permutation.size() - 1);
                remaining.add(i, element);
            }
        }
    }
}


