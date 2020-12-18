package arvoregenealogica;
public class Pessoa {
    
    private Pessoa pai;
    private Pessoa mae;
    String nome;
    
    public Pessoa(Pessoa pai, Pessoa mae, String nome){
        this.pai = pai;
        this.mae = mae;
        this.nome = nome;
    }
    public Pessoa(String nome){
        this.pai = null;
        this.mae = null;
        this.nome = nome;
    }
    public Pessoa getPai() {
        return pai;
    }
    public void setPai(Pessoa pai) {
        this.pai = pai;
    }
    public Pessoa getMae() {
        return mae;
    }
    public void setMae(Pessoa mae) {
        this.mae = mae;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public boolean saoIguais(Pessoa pessoa){
        boolean paiLogico = false, maeLogico = false, nomeLogico = false;
        if(this.mae != null && pessoa.mae != null){
            maeLogico = this.mae == pessoa.mae;
        }
       if(this.pai != null && pessoa.pai != null){
            paiLogico = this.pai == pessoa.pai;
        }
       nomeLogico = this.nome.equals(pessoa.nome);
        return nomeLogico && maeLogico && paiLogico;
    }
    public boolean saoIrmaos(Pessoa pessoa){
        boolean paiLogico = false;
        boolean maeLogico = false;
        if(saoIguais(pessoa)){
            return false;
        }
        if(this.mae != null && pessoa.mae != null){
            maeLogico = this.mae == pessoa.mae;
        }
        if(this.pai != null && pessoa.pai != null){
            paiLogico = this.pai == pessoa.pai;
        }
       return paiLogico || maeLogico;
    }
    public boolean ehAntecessor(Pessoa pessoa){
        boolean paiLogico = false;
        boolean maeLogico = false;
        boolean paiPaiLogico = false;
        boolean maeMaeLogico = false;
        boolean paiMaeLogico = false;
        boolean maePaiLogico = false;
        if(this.mae != null){
            if(this.mae.mae != null){
                maeMaeLogico = this.mae.mae == pessoa;
            }
            if(this.mae.pai != null){
                maePaiLogico = this.mae.mae == pessoa;
            }
            maeLogico = this.mae == pessoa;
        }
        if(this.pai != null){
            if(this.pai.pai != null){
               paiPaiLogico = this.pai.pai == pessoa;
            }
            if(this.pai.mae != null){
               paiMaeLogico = this.pai.pai == pessoa;
            }
            paiLogico = this.pai == pessoa;
        }
        return paiLogico
               || maeLogico
               || paiMaeLogico
               || paiPaiLogico
               || maePaiLogico
               || maeMaeLogico;
    }
}














