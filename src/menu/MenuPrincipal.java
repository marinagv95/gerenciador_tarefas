package menu;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    public void ExibirMenuPrincipal() {
        Scanner sc = new Scanner(System.in);
        List<String> atividades = new ArrayList<String>();
        List<String> descricao = new ArrayList<String>();
        List<String> status = new ArrayList<String>();
        int opcao = -1;
        boolean existe = false;


        while (opcao != 8) {
            System.out.println("-".repeat(10) + "MENU" + "-".repeat(10));
            System.out.println("1 - Adicionar Nova Atividade");
            System.out.println("2 - Pesquisar Atividade por Título");
            System.out.println("3 - Excluir Atividade pelo Título");
            System.out.println("4 - Atualizar Atividade pelo Título");
            System.out.println("5 - Iniciar Atividade");
            System.out.println("6 - Finalizar Atividade");
            System.out.println("7 - Listar Atividades");
            System.out.println("8 - Sair do Sistema");
            System.out.print("Digite a Opção Desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o Título da Atividade: ");
                    String tituloAtividade = sc.nextLine();
                    System.out.print("Digite a Descrição da Atividade: ");
                    String descricaoAtividade = sc.nextLine();

                    atividades.add(tituloAtividade);
                    descricao.add(descricaoAtividade);
                    status.add("Pendente");
                    System.out.println("Atividade Adicionada com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o Título da Atividade: ");
                    String buscarAtividade = sc.nextLine();
                    existe = false;

                    if (atividades.isEmpty()) {
                        System.out.println("Sua Lista de Atividades está vazia!");
                    } else {
                        for (int i = 0; i < atividades.size(); i++) {
                            if (atividades.get(i).equalsIgnoreCase(buscarAtividade)) {
                                System.out.println("Atividade: " + atividades.get(i) +
                                        " Descrição: " + descricao.get(i) +
                                        " Status: " + status.get(i));
                                existe = true;

                            }
                        }
                        if (!existe) {
                            System.out.println("Atividade não encontrada!");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o Título da Atividade para excluír: ");
                    String removerAtividade = sc.nextLine();
                    existe = false;
                    if (atividades.isEmpty()) {
                        System.out.println("Sua lista está vazia!");
                    } else {
                        for (int i = 0; i < atividades.size(); i++) {
                            if (atividades.get(i).equalsIgnoreCase(removerAtividade)) {
                                atividades.remove(i);
                                descricao.remove(i);
                                status.remove(i);
                                System.out.println("Atividade Removida com sucesso!");
                                existe = true;

                            }
                        }
                        if (!existe) {
                            System.out.println("Atividade não encontrada!");
                        }
                    }

                    break;
                case 4:
                    existe = false;
                    System.out.print("Digite o Título da Atividade para Atualizar: ");
                    String atualizarAtividade = sc.nextLine();


                    if (atividades.isEmpty()) {
                        System.out.println("Sua lista está vazia!");
                    } else {
                        for (int i = 0; i < atividades.size(); i++) {
                            if (atividades.get(i).equalsIgnoreCase(atualizarAtividade)) {
                                System.out.print("Digite o novo Título da Atividade: ");
                                String novaAttAtividade = sc.nextLine();
                                atividades.set(i, novaAttAtividade);
                                System.out.println("Atividade Atualizada com sucesso!");

                                System.out.print("Deseja também Atualizar a Descrição? (s/n): ");
                                String continueAttDescricao = sc.nextLine();

                                if (continueAttDescricao.equalsIgnoreCase("s")) {
                                    System.out.print("Digite a nova Descrição da Atividade: ");
                                    String novaDescricao = sc.nextLine();
                                    descricao.set(i, novaDescricao);
                                    System.out.println("Descrição Atualizada com sucesso!");
                                }

                                existe = true;

                            }
                        }
                        if (!existe) {
                            System.out.println("Atividade não encontrada!");
                        }
                    }

                    break;
                case 5:
                    existe = false;
                    System.out.print("Digite o Título da Atividade para iniciar: ");
                    String iniciaAtividade = sc.nextLine();
                    if (atividades.isEmpty()) {
                        System.out.println("Sua lista está vazia!");
                    } else {
                        for (int i = 0; i < atividades.size(); i++) {
                            if (atividades.get(i).equalsIgnoreCase(iniciaAtividade) && status.get(i).equalsIgnoreCase("Pendente")) {
                                status.set(i, "Em andamento");
                                System.out.println("Atividade iniciada com sucesso!");
                                existe = true;

                            }

                        }
                        if (!existe) {
                            System.out.println("Atividade não encontrada ou já está em andamento.");
                        }
                    }
                    break;
                case 6:
                    existe = false;
                    System.out.print("Digite o Título da Atividade para finalizar: ");
                    String finalizarAtividade = sc.nextLine();

                    if (atividades.isEmpty()) {
                        System.out.println("Sua lista está vazia!");
                    } else {
                        for (int i = 0; i < atividades.size(); i++) {
                            if (atividades.get(i).equalsIgnoreCase(finalizarAtividade) && status.get(i).equalsIgnoreCase("Em andamento")) {
                                status.set(i, "Concluída");
                                System.out.println("Atividade Finalizada com sucesso!");
                                existe = true;

                            }
                        }
                        if (!existe) {
                            System.out.println("Atividade não encontrada");
                        }
                    }

                    break;
                case 7:

                    int subopcao = -1;
                    boolean existeSubMenu = false;
                    while (subopcao != 5) {

                        System.out.println("1 -  Listar Todas as Atividades");
                        System.out.println("2 -  Listar Atividades Pendentes");
                        System.out.println("3 -  Listar Atividades Em andamento");
                        System.out.println("4 -  Listar Atividades Concluídas");
                        System.out.println("5 -  Voltar ao Menu Principal");

                        System.out.print("Digite a Opção desejada: ");
                        subopcao = sc.nextInt();
                        switch (subopcao) {
                            case 1:
                                if (atividades.isEmpty()) {
                                    System.out.println("Nenhuma atividade cadastrada");
                                } else {
                                    for (int i = 0; i < atividades.size(); i++) {
                                        System.out.println(i + 1 + ") Atividade: " + atividades.get(i) + " " + "Descrição: " + descricao.get(i) + " " + "Status: " + status.get(i));
                                    }

                                }

                                break;
                            case 2:
                                if (atividades.isEmpty()) {
                                    System.out.println("Nenhuma atividade cadastrada");
                                } else {
                                    for (int i = 0; i < status.size(); i++) {
                                        if (status.get(i).equalsIgnoreCase("Pendente")) {
                                            System.out.println(i + 1 + ") Atividade: " + atividades.get(i) + " " + "Descrição: " + descricao.get(i) + " " + "Status: " + status.get(i));
                                            existeSubMenu = true;

                                        }
                                    }
                                    if (!existeSubMenu) {
                                        System.out.println("Nenhuma atividade pendente cadastrada.");
                                    }

                                }
                                break;
                            case 3:
                                if (atividades.isEmpty()) {
                                    System.out.println("Nenhuma atividade cadastrada");
                                } else {
                                    for (int i = 0; i < status.size(); i++) {
                                        if (status.get(i).equalsIgnoreCase("Em andamento")) {
                                            System.out.println(i + 1 + ") Atividade: " + atividades.get(i) + " " + "Descrição: " + descricao.get(i) + " " + "Status: " + status.get(i));
                                            existeSubMenu = true;

                                        }
                                    }
                                    if (!existeSubMenu) {
                                        System.out.println("Nenhuma atividade em andamento cadastrada.");
                                    }


                                }
                                break;
                            case 4:
                                if (atividades.isEmpty()) {
                                    System.out.println("Nenhuma atividade cadastrada");
                                } else {
                                    for (int i = 0; i < status.size(); i++) {
                                        if (status.get(i).equalsIgnoreCase("Concluída")) {
                                            System.out.println(i + 1 + ") Atividade: " + atividades.get(i) + " " + "Descrição: " + descricao.get(i) + " " + "Status: " + status.get(i));
                                            existeSubMenu = true;

                                        }
                                    }
                                    if (!existeSubMenu) {
                                        System.out.println("Nenhuma atividade concluída cadastrada.");
                                    }


                                }
                                break;
                            case 5:
                                System.out.println("Voltando ao menu Principal...");
                                break;
                        }

                    }
                case 8:
                    System.out.println("Saindo do programa... Até logo!");
                    break;

            }

        }
        sc.close();

    }
}
