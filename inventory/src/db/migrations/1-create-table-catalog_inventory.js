/** @type {import('sequelize-cli').Migration} */
module.exports = {
  async up(queryInterface, Sequelize) {
    await queryInterface.createTable('inventory', {
      id: {
        type: Sequelize.INTEGER,
        primaryKey: true,
        autoIncrement: true,
      },
      name: {
        type: Sequelize.STRING,
        allowNull: false,
      },
      eventDateTime: {
        type: Sequelize.DATE,
        allowNull: false,
        field: 'event_date_time',
      },
      ticketsAvailable: {
        type: Sequelize.INTEGER,
        allowNull: false,
        field: 'tickets_available',
      },
    });
  },

  async down(queryInterface, _Sequelize) {
    await queryInterface.dropTable('inventory', null, {});
  },
};
