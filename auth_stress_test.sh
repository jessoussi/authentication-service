#!/bin/bash

# ==================================================
# SCRIPT POUR TESTER L'ENDPOINT D'AUTHENTIFICATION
# Exécute un appel POST cURL avec des données JSON.
# ==================================================

# --- 1. Vérification des arguments d'entrée ---

if [ "$#" -ne 1 ]; then
    echo "Usage: $0 <Nombre_de_répétitions>"
    echo "Exemple: $0 50"
    exit 1
fi

REPETITIONS="$1"
URL_TARGET="http://localhost:8080/api/authenticate"
JSON_DATA='{ "mail": "user1@mail.com", "password": "password1"}'

echo "============================================"
echo "🎯 URL Cible : $URL_TARGET"
echo "🔢 Répétitions : $REPETITIONS"
echo "🔑 Données envoyées : $JSON_DATA"
echo "============================================"

# --- 2. Boucle d'exécution ---

for i in $(seq 1 $REPETITIONS); do
    echo "--- Test $i / $REPETITIONS ---"
    
    # Exécution de la commande curl avec les options de votre requête POST
    
    # Options utilisées :
    # -s : Mode silencieux (pas de barre de progression/erreurs verbeuses)
    # -o /dev/null : Jeter le corps de la réponse pour ne garder que les métriques
    # -w "..." : Formater la sortie pour afficher les métriques clés
    
    curl -s \
         -o /dev/null \
         -w "Code HTTP: %{http_code}\t Temps Total: %{time_total}s\n" \
         --location "$URL_TARGET" \
         --header 'Content-Type: application/json' \
         --data-raw "$JSON_DATA"

done

echo "============================================"
echo "✅ Tous les $REPETITIONS tests sont terminés."
