#!/bin/bash
set -euo pipefail

if ! command -v gh >/dev/null 2>&1; then
  echo "❌ A CLI do GitHub (gh) não está instalada. Instale: https://cli.github.com/"
  exit 1
fi

if ! command -v git >/dev/null 2>&1; then
  echo "❌ O Git não está instalado."
  exit 1
fi

echo "🔐 Verificando autenticação no GitHub..."
gh auth status || gh auth login

read -p "📝 Nome do repositório (ex: seu-usuario/gymtracker): " REPO

git init
git add .
git commit -m "Esqueleto inicial React + Spring Boot para GymTracker" || true
git branch -M main

echo "📦 Criando repositório e fazendo push..."
gh repo create "$REPO" --public --source=. --remote=origin --push

echo "✅ Tudo pronto! Repositório publicado: https://github.com/$REPO"
