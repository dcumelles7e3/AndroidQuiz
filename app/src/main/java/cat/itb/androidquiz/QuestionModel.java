package cat.itb.androidquiz;

public class QuestionModel {
    private boolean resposta;
    private int pregunta;

    public QuestionModel(boolean resposta, int pregunta) {
        this.resposta = resposta;
        this.pregunta = pregunta;
    }

    public boolean isResposta() {
        return resposta;
    }

    public void setResposta(boolean resposta) {
        this.resposta = resposta;
    }

    public int getPregunta() {
        return pregunta;
    }

    public void setPregunta(int pregunta) {
        this.pregunta = pregunta;
    }
}
