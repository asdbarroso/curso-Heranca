package aplicacoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class Programa {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Produto> listaProduto = new ArrayList<>();
		
		System.out.print("Entre com a quantidade de produtos:");
		int n = in.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Dados do Produto #" + i);
			System.out.print("Comum, usado ou importado (c/u/i)?");
			char p = in.next().charAt(0);
			in.nextLine();

			System.out.print("Nome: ");
			String nome = in.nextLine();
			System.out.print("Preço: ");
			double preco = in.nextDouble();
			
			if (p == 'c') {
				listaProduto.add(new Produto(nome, preco));
			}

			if (p == 'u') {
				System.out.print("Data de validade (DD/MM/AAAA) ");
				Date validade = sdf.parse(in.next());
				listaProduto.add(new ProdutoUsado(nome, preco, validade));
			}

			if (p == 'i') {
				System.out.print("Taxa: ");
				double taxa = in.nextDouble();
				listaProduto.add(new ProdutoImportado(nome, preco, taxa));
			}

		}
		
		for(Produto l : listaProduto) {
			System.out.println(l.etiquetaPreco());
		}

		in.close();
	}

}