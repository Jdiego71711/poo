public class Variables {

    public static void main(String[] args) {

        double d1 = 42.0;
        double d2 = 58.5;
        double d3 = 37.2; 
        double t1 = 0.9;
        double t2 = 1.4;
        double t3 = 0.8;
        double l1 = 5.1;
        double l2 = 6.9;
        double l3 = 4.3;
        double precLitro = 1.35;
        double masacargakg = 1200;
        double largo = 2.0;
        double ancho = 1.2;
        double alto = 1.1;
        double p1 = 2.5;
        double P2 = 3.0;
        double p3 = 2.0;
        double deprePorKm = 0.08;
        double volcamionM3 = 10.0;
        double fCO2 = 2.68;
        double galPorLitro = 0.264172;
        double vmin = 30;
        double vmax = 90;
        double va = 40;
        double vb = 80;
        double ca = 0.05;
        double cb = 0.09;
        double a = -0.0008;
        double b = 0.08;
        double c = 4.0;
        double w1 = 0.25;
        double w2 = 0.25;
        double w3 = 0.25;
        double w4 = 0.25;

        double v1 = 0;
        double v2 = 0;
        double v3 = 0;
        double vprom = 0;
        double kml1 = 0;
        double kml2 = 0;
        double kml3 = 0;
        double kmltotal = 0;
        double costoComb = 0;
        double deprec = 0;
        double peajes = 0;
        double costoDirecto = 0;
        double costoPorKm = 0;
        double volumenM3 = 0;
        double densidad = 0;
        double ocupacion = 0;
        double C02Total = 0;
        double C02porKm = 0;
        double vmsprom = 0;
        double galTot = 0;
        double vnorm = 0;
        double cvprom = 0;
        double costoMant = 0;
        double vmedia = 0;
        double raiz = 0;
        double vpondt = 0;
        double kmlv = 0;
        double kmlModelo = 0;
        double litrosModelo = 0;
        double score = 0;

        v1 = d1 / t1;
        v2 = d2 / t2;
        v3 = d3 / t3;

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        vprom = (d1 * v1 + d2 * v2 + d3 * v3) / (d1 + d2 + d3);

        System.out.println(vprom);

        kml1 = d1 / l1;
        kml2 = d2 / l2;
        kml3 = d3 / l3;

        System.out.println(kml1);
        System.out.println(kml2);
        System.out.println(kml3);

        kmltotal = (d1 + d2 + d3) / (l1 + l2 + l3);

        System.out.println(kmltotal);

        costoComb = (l1 + l2 + l3) * precLitro;

        deprec = (d1 + d2 + d3) * deprePorKm;

        peajes = p1 + P2 + p3;

        System.out.println(costoComb);
        System.out.println(deprec);
        System.out.println(peajes);

        costoDirecto = costoComb + deprec + peajes;
        costoPorKm = costoDirecto / (d1 + d2 + d3);

        System.out.println(costoDirecto);
        System.out.println(costoPorKm);

        volumenM3 = largo * ancho * alto;
        densidad = masacargakg / volumenM3;
        ocupacion = volumenM3 / volcamionM3;

        System.out.println(volumenM3);
        System.out.println(densidad);
        System.out.println(ocupacion);

        C02Total = (l1 + l2 + l3) * fCO2;
        C02porKm = C02Total / (d1 + d2 + d3);

        System.out.println(C02Total);
        System.out.println(C02porKm);

        vmsprom = (vprom * 1000) / 3600;
        galTot = (l1 + l2 + l3) * galPorLitro;

        System.out.println(vmsprom);
        System.out.println(galTot);

        vnorm = (vprom - vmin) / (vmax - vmin);

        System.out.println(vnorm);

        vmedia = (v1 + v2 + v3) / 3;

        raiz = Math.sqrt((Math.pow(v1 - vmedia, 2) + Math.pow(v2 - vmedia, 2) + Math.pow(v3 - vmedia, 2)) / 3);

        vpondt = (t1 * v1 + t2 * v2 + t3 * v3) / (t1 + t2 + t3);

        System.out.println(vmedia);
        System.out.println(raiz);
        System.out.println(vpondt);

        cvprom = ca + (cb - ca) * (vprom - va) / (vb - va);
        costoMant = cvprom * (d1 + d2 + d3);

        System.out.println(cvprom);
        System.out.println(costoMant);

        kmlv = a * Math.pow(vprom, 2) + b * vprom + c;
        kmlModelo = kmlv;
        litrosModelo = (d1 + d2 + d3) / kmlModelo;

        System.out.println(kmlv);
        System.out.println(litrosModelo);

        score = (w1 * 1) / costoPorKm + w2 * kmltotal + (w3 * 1) / C02porKm + (w4 * 1) / (1 + raiz);

        System.out.println(score);
    }
}