package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service
{
    static List<Customer> customerList = new ArrayList<>();
    static int choiceAction;
    static int choiceUpdate;
    static int choiceUpdateTwo;
    static int quantity;
    static float totalPriceProduct;
    static float totalPriceCustomer;
    static String cpfUpdate;
    static String newName;
    static String newCpf;

    public static void main()
    {

        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.println("=================================");
        System.out.println("=Bem vindo ao sistema de compras=");
        System.out.println("=================================");
        totalPriceProduct = 0;
        totalPriceCustomer = 0;
        LOOP1:
        while(true)
        {
            System.out.println("Você deseja:");
            System.out.println("(1)Cadastrar clientes\n(2)Atualizar clientes");
            System.out.println("(3)Remover clientes\n(4)Ver clientes\n(5)Sair do programa");
            choiceAction = scannerInt.nextInt();
            if(choiceAction == 1)
            {
                signCustomer();
            }
            else if(choiceAction == 2)
            {
                if(customerList.size() == 0)
                {
                    System.out.println("Desculpe, não temos clientes cadastrados para serem atualizados");
                    continue LOOP1;
                }
                else
                {
                    System.out.println("Digite o CPF do cliente que deseja atualizar informações: ");
                    cpfUpdate = scannerStr.nextLine();

                        LOOP2:
                        for(int x = 0; x < customerList.size(); x++)
                        {
                            if(customerList.get(x).customerCpf.equals(cpfUpdate))
                            {
                                System.out.println("O que deseja atualizar?\n(1)Dados cliente\t(2)Produtos cliente");
                                choiceUpdate = scannerInt.nextInt();

                                if(choiceUpdate == 1)
                                {
                                    System.out.println("Deseja atualizar:\n(1)Nome\t(2)CPF\n(3)Ambas");
                                    choiceUpdateTwo = scannerInt.nextInt();

                                    if(choiceUpdateTwo == 1)
                                    {
                                        System.out.printf("Digite o novo nome para o cliente %s:\n",customerList.get(x).customerName);

                                        newName = scannerStr.nextLine();

                                        customerList.get(x).customerName = newName;
                                    }
                                    else if(choiceUpdateTwo == 2)
                                    {
                                        System.out.printf("Digite o novo cpf para o cliente %s:\n",customerList.get(x).customerName);

                                        newCpf = scannerStr.nextLine();

                                        customerList.get(x).customerCpf = newCpf;
                                    }
                                    else if(choiceUpdateTwo == 3)
                                    {
                                        System.out.printf("Digite o novo nome para o cliente %s:\n",customerList.get(x).customerName);

                                        newName = scannerStr.nextLine();

                                        System.out.printf("Digite o novo cpf para o cliente %s:\n",customerList.get(x).customerName);

                                        newCpf = scannerStr.nextLine();

                                        customerList.get(x).customerName = newName;
                                        customerList.get(x).customerCpf = newCpf;
                                    }
                                    else
                                    {
                                        System.out.println("A opção informada não é valida!");
                                        continue LOOP2;
                                    }
                                }

                                else if(choiceUpdate == 2)
                                {
                                    System.out.println("Não é possível atualizar os produtos");
                                    continue LOOP2;

                                }
                                else
                                {
                                    System.out.println("A opção informada não é valida!");
                                    continue LOOP2;
                                }
                            }
                        }
                }
            }
            else if(choiceAction == 3)
            {
                if(customerList.size() == 0)
                {
                    System.out.println("Desculpe, não temos clientes cadastrados para serem removidos");
                    continue LOOP1;
                }
                else
                {
                    removeCustomer();
                }
            }
            else if(choiceAction == 4)
            {
                if(customerList.size() == 0)
                {
                    System.out.println("Desculpe, não temos clientes cadastrados para serem visualizados");
                    continue LOOP1;
                }
                else
                {
                    visualizeCustomers();
                }
            }
            else if(choiceAction == 5)
            {
                break;
            }
            else
            {
                System.out.println("Opa, não conseguimos identificar o que você deseja!");
                continue LOOP1;
            }
        }
    }
    public static void removeCustomer()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o cpf do cliente que deseja remover: ");

        newCpf = scanner.nextLine();
        for(int x = 0; x < customerList.size(); x++)
        {
            if(customerList.get(x).customerCpf.equals(newCpf))
            {
                customerList.remove(x);
                System.out.println("Cliente foi removido dos registros!");
            }
        }
    }
    public static void visualizeCustomers()
    {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        int choice;
        String cpf;
        System.out.println("Deseja visualizar:\n(1)Um único cliente\t(2)Todos os clientes");
        choice = scanner.nextInt();

        if(choice == 1)
        {
            System.out.println("Digite o cpf do cliente que deseja visualizar:");
            cpf = scannerStr.nextLine();

            for(int x = 0; x < customerList.size(); x++)
            {
                if(customerList.get(x).customerCpf.equals(cpf))
                {
                    System.out.println(customerList.get(x).customerName);
                    System.out.println(customerList.get(x).customerCpf);
                    System.out.println(customerList.get(x).totalShop);
                }
            }
        }
        if(choice == 2)
        {
            for(Customer c: customerList)
            {
                System.out.println(c.customerName);
                System.out.println(c.customerCpf);
                System.out.println(c.totalShop);
            }
        }
    }

    public static void signCustomer()
    {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerFlt = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.println("Digite o nome do cliente: ");
        customer.customerName = scannerStr.nextLine();

        System.out.println("Digite o cpf do cliente: ");
        customer.customerCpf = scannerStr.nextLine();

        System.out.println("Quantos produtos diferentes tem no carrinho? ");
        quantity = scannerInt.nextInt();

        LOOP1:
        for(int x = 0; x < quantity; x++)
        {
            Products products = new Products();


            System.out.println("Digite o ID do produto: ");
            products.productId = scannerInt.nextInt();

            System.out.println("Digite o nome desse produto: ");
            products.productName = scannerStr.nextLine();

            System.out.printf("Digite a quantidade do produto %s:\n",products.productName);
            products.productQuantity = scannerInt.nextInt();

            if(products.productQuantity < 1)
            {
                System.out.println("Desculpe, a quantidade não foi aceita");
                continue LOOP1;
            }

            System.out.printf("Digite o preço do produto %s:\n",products.productName);
            products.productPrice = scannerFlt.nextFloat();

            if(products.productPrice < 0.01)
            {
                System.out.println("Desculpe, o valor não foi aceito");
                continue LOOP1;
            }

            totalPriceProduct = totalPriceProduct + (products.productPrice * products.productQuantity);
            products.total = totalPriceProduct;
            customer.productsList.add(products);
            System.out.printf("%s adicionado com sucesso!\n",products.productName);
        }
        for(int z = 0; z < customer.productsList.size(); z++)
        {
            totalPriceCustomer = totalPriceCustomer + (customer.productsList.get(z).total);
        }
        customer.totalShop = totalPriceCustomer;

        if(customer.totalShop < 100)
        {
            customer.totalShop = customer.totalShop + (customer.totalShop * 1 / 100);
        }
        else
        {
            customer.totalShop = customer.totalShop - (customer.totalShop * 10 / 100);
        }
        customerList.add(customer);
        System.out.printf("Cliente %s foi cadastrado!!",customer.customerName);

    }
}
